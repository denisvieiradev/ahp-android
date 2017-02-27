package com.ahpandroid.ahpmethod.AhpSteps;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.ahpandroid.R;
import com.ahpandroid.databinding.AhpMethodComparisonItemBinding;
import com.ahpandroid.domain.entity.ComparisonItem;
import com.ahpandroid.domain.enums.ComparisonDefinitionEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by denisvieira on 22/02/17.
 */

public class AhpComparionItemAdapter extends RecyclerView.Adapter<AhpComparionItemAdapter.ItemViewHolder>{

    private List<ComparisonItem> mComparisonItems;
    private Context mContext;
    private ItemViewHolder mViewHolder;
    private ComparisonItem mComparisonItem;
    private int itemPosition;

    public AhpComparionItemAdapter(Context context,
                                              List<ComparisonItem> comparisonItems){
        this.mContext         = context;
        this.mComparisonItems = comparisonItems;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AhpMethodComparisonItemBinding ahpMethodComparisonItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.ahp_method_comparison_item,
                parent,
                false);

        ahpMethodComparisonItemBinding.setHandler(this);
        final ItemViewHolder vh = new ItemViewHolder(ahpMethodComparisonItemBinding);
        return vh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        mViewHolder = holder;
        itemPosition = position;
        ComparisonItem comparisonItem = mComparisonItems.get(position);
        mViewHolder.mAhpMethodComparisonItemBinding.setComparisonItem(comparisonItem);
        mViewHolder.mAhpMethodComparisonItemBinding.ahpMethodComparisonItemDefinitionComparisonTextView.setText(mContext.getString(getComparisonDefinitionTextId(comparisonItem.getDefinitionText())));

        mViewHolder.itemView.setOnClickListener(view -> {
            ComparisonItem ComparisonItem = (ComparisonItem) view.getTag();
//            mDashboardViewContract.showProblemIdentifiedDetail(ComparisonItem);
        });

        mViewHolder.mAhpMethodComparisonItemBinding.ahpMethodCriterionOneStepFirstSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ComparisonItem comparisonItem = mComparisonItems.get(position);
                comparisonItem = updateSeekBarRealValues(comparisonItem,seekBar.getProgress());
                mComparisonItems.set(position,comparisonItem);
                mViewHolder = holder;
                mViewHolder.mAhpMethodComparisonItemBinding.setComparisonItem(comparisonItem);
                mViewHolder.mAhpMethodComparisonItemBinding.ahpMethodComparisonItemDefinitionComparisonTextView.setText(mContext.getString(getComparisonDefinitionTextId(comparisonItem.getDefinitionText())));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mViewHolder.mAhpMethodComparisonItemBinding.executePendingBindings();
    }

    public void replaceData(List list) {
        mComparisonItems = list;
        notifyDataSetChanged();
    }

    private ComparisonItem updateSeekBarRealValues(ComparisonItem comparisonItem,int progress) {

        switch (progress) {

            case 0:
                comparisonItem.setFirstAlternativeValue("1/9");
                comparisonItem.setSecondAlternativeValue("9");
                comparisonItem.setDefinitionText(ComparisonDefinitionEnum.ABSOLUTE.getValue());
                break;
            case 1:
                comparisonItem.setFirstAlternativeValue("1/7");
                comparisonItem.setSecondAlternativeValue("7");
                comparisonItem.setDefinitionText(ComparisonDefinitionEnum.VERY_STRONG.getValue());
                break;
            case 2:
                comparisonItem.setFirstAlternativeValue("1/5");
                comparisonItem.setSecondAlternativeValue("5");
                comparisonItem.setDefinitionText(ComparisonDefinitionEnum.STRONG.getValue());
                break;
            case 3:
                comparisonItem.setFirstAlternativeValue("1/3");
                comparisonItem.setSecondAlternativeValue("3");
                comparisonItem.setDefinitionText(ComparisonDefinitionEnum.TWEAK.getValue());
                break;
            case 4:
                comparisonItem.setFirstAlternativeValue("1");
                comparisonItem.setSecondAlternativeValue("1");
                comparisonItem.setDefinitionText(ComparisonDefinitionEnum.EQUAL.getValue());
                break;
            case 5:
                comparisonItem.setFirstAlternativeValue("3");
                comparisonItem.setSecondAlternativeValue("1/3");
                comparisonItem.setDefinitionText(ComparisonDefinitionEnum.TWEAK.getValue());
                break;
            case 6:
                comparisonItem.setFirstAlternativeValue("5");
                comparisonItem.setSecondAlternativeValue("1/5");
                comparisonItem.setDefinitionText(ComparisonDefinitionEnum.STRONG.getValue());
                break;
            case 7:
                comparisonItem.setFirstAlternativeValue("7");
                comparisonItem.setSecondAlternativeValue("1/7");
                comparisonItem.setDefinitionText(ComparisonDefinitionEnum.VERY_STRONG.getValue());
                break;
            case 8:
                comparisonItem.setFirstAlternativeValue("9");
                comparisonItem.setSecondAlternativeValue("1/9");
                comparisonItem.setDefinitionText(ComparisonDefinitionEnum.ABSOLUTE.getValue());
                break;
        }

        return comparisonItem;
    }

    private int getComparisonDefinitionTextId(int enumSituationValue) {

        Map<Integer, Integer> comparisonDefinitionText = new HashMap<Integer, Integer>();
        comparisonDefinitionText.put(ComparisonDefinitionEnum.EQUAL.getValue(), R.string.ahp_method_comparison_definitions_equal_importance);
        comparisonDefinitionText.put(ComparisonDefinitionEnum.TWEAK.getValue(), R.string.ahp_method_comparison_definitions_tweak_importance);
        comparisonDefinitionText.put(ComparisonDefinitionEnum.STRONG.getValue(), R.string.ahp_method_comparison_definitions_strong_importance);
        comparisonDefinitionText.put(ComparisonDefinitionEnum.VERY_STRONG.getValue(), R.string.ahp_method_comparison_definitions_very_strong_importance);
        comparisonDefinitionText.put(ComparisonDefinitionEnum.ABSOLUTE.getValue(), R.string.ahp_method_comparison_definitions_absolute_importance);
        comparisonDefinitionText.put(ComparisonDefinitionEnum.INTERMEDIARY.getValue(), R.string.ahp_method_comparison_definitions_intermediary_values);
        int comparisonDefinitionTextId = comparisonDefinitionText.get(enumSituationValue);

        return comparisonDefinitionTextId;
    }

    @Override
    public int getItemCount() {
        return mComparisonItems.size();
    }

    public List<ComparisonItem> getComparisonItems() {
        return mComparisonItems;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private AhpMethodComparisonItemBinding mAhpMethodComparisonItemBinding;

        public ItemViewHolder(AhpMethodComparisonItemBinding ahpMethodComparisonItemBinding) {
            super(ahpMethodComparisonItemBinding.getRoot());
            this.mAhpMethodComparisonItemBinding = ahpMethodComparisonItemBinding;
        }
    }
}
