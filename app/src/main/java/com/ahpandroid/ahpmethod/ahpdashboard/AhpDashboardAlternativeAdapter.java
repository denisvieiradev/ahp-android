package com.ahpandroid.ahpmethod.ahpdashboard;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.ahpandroid.R;
import com.ahpandroid.databinding.AhpDashboardAlternativeItemBinding;
import com.ahpandroid.domain.entity.Alternative;
import com.ahpandroid.utils.GuidGenerator;

import java.util.List;
import java.util.Locale;

/**
 * Created by denisvieira on 19/02/17.
 */

public class AhpDashboardAlternativeAdapter extends RecyclerSwipeAdapter<AhpDashboardAlternativeAdapter.ItemViewHolder> {

    private List<String> mAlternatives;
    private Context mContext;
    private AhpDashboardContract.View mAhpDashboardContract;
    private ItemViewHolder mViewHolder;
    private TextToSpeech tts;

    private void setList(List<String> list) {
        mAlternatives = list;
    }

    public AhpDashboardAlternativeAdapter(List<String> alternatives, Context context, AhpDashboardContract.View ahpDashboardContract) {
        this.mAlternatives = alternatives;
        this.mContext = context;
        this.mAhpDashboardContract = ahpDashboardContract;
    }

    public List<String> getAlternatives(){
        return mAlternatives;
    }

    public void replaceData(List<String> itemsMethod) {
        setList(itemsMethod);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mAlternatives.size();
    }

    public void addItem(String alternativeTitle){
        String alternative = alternativeTitle;
        mAlternatives.add(alternative);
        notifyDataSetChanged();
        mAhpDashboardContract.checkListsContent();
    }
    public void removeItem(int position){
        mAlternatives.remove(position);
        notifyDataSetChanged();
        mAhpDashboardContract.checkListsContent();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.ahp_dashboard_alternative_item_swipe_layout;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AhpDashboardAlternativeItemBinding ahpDashboardAlternativeItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.ahp_dashboard_alternative_item,
                        parent, false);

        return new ItemViewHolder(ahpDashboardAlternativeItemBinding);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        mViewHolder = holder;

        String alternative = mAlternatives.get(position);
        holder.mAhpDashboardAlternativeItemBinding.setAlternative(alternative);

        holder.mAhpDashboardAlternativeItemBinding.executePendingBindings();

        holder.mAhpDashboardAlternativeItemBinding.ahpDashboardRemoveAlternativeLinearLayout.setOnClickListener(v -> {
            removeItem(position);
        });

        holder.mAhpDashboardAlternativeItemBinding.ahpDashboardAddAlternativeClickToPlay.setOnClickListener(view -> {
            tts = new TextToSpeech(mContext, status -> {
                if (status == TextToSpeech.SUCCESS) {

                    int result = tts.setLanguage(Locale.getDefault());

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "This Language is not supported");
                    } else {
                        holder.mAhpDashboardAlternativeItemBinding.ahpDashboardAddAlternativeClickToPlay.setEnabled(true);
                        String text = holder.mAhpDashboardAlternativeItemBinding.ahpDashboardAlternativeItemTittle.getText().toString();

                        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                    }

                } else {
                    Log.e("TTS", "Initilization Failed!");
                }
            });

        });
    }



    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private AhpDashboardAlternativeItemBinding mAhpDashboardAlternativeItemBinding;

        public ItemViewHolder(AhpDashboardAlternativeItemBinding ahpDashboardAlternativeItemBinding) {
            super(ahpDashboardAlternativeItemBinding.getRoot());

            this.mAhpDashboardAlternativeItemBinding = ahpDashboardAlternativeItemBinding;

        }
    }
}
