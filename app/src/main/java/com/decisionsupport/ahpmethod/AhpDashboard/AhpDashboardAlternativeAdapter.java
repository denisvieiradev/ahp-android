package com.decisionsupport.ahpmethod.AhpDashboard;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.decisionsupport.R;
import com.decisionsupport.databinding.AhpDashboardAlternativeItemBinding;
import com.decisionsupport.domain.entity.Alternative;
import com.decisionsupport.domain.entity.Criterion;
import com.decisionsupport.utils.GuidGenerator;

import java.util.List;

/**
 * Created by denisvieira on 19/02/17.
 */

public class AhpDashboardAlternativeAdapter extends RecyclerSwipeAdapter<AhpDashboardAlternativeAdapter.ItemViewHolder> {

    private List<Alternative> mAlternatives;
    private Context mContext;
    private AhpDashboardContract.View mAhpDashboardContract;
    private ItemViewHolder mViewHolder;

    private void setList(List<Alternative> list) {
        mAlternatives = list;
    }

    public AhpDashboardAlternativeAdapter(List<Alternative> alternatives, Context context, AhpDashboardContract.View ahpDashboardContract) {
        this.mAlternatives = alternatives;
        this.mContext = context;
        this.mAhpDashboardContract = ahpDashboardContract;
    }

    public void replaceData(List<Alternative> itemsMethod) {
        setList(itemsMethod);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mAlternatives.size();
    }

    public void addItem(String alternativeTitle){
        Alternative alternative = new Alternative(GuidGenerator.generate(),alternativeTitle);
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

        Alternative alternative = mAlternatives.get(position);
        holder.mAhpDashboardAlternativeItemBinding.setAlternative(alternative);

        holder.mAhpDashboardAlternativeItemBinding.executePendingBindings();

        holder.mAhpDashboardAlternativeItemBinding.ahpDashboardRemoveAlternativeLinearLayout.setOnClickListener(v -> {
            removeItem(position);
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
