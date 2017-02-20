package com.decisionsupport.ahpmethod.AhpDashboard;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.decisionsupport.R;
import com.decisionsupport.databinding.AhpDashboardAddAlternativeDialogBinding;
import com.decisionsupport.databinding.AhpDashboardAddCriterionDialogBinding;
import com.decisionsupport.databinding.AhpDashboardFragBinding;
import com.decisionsupport.domain.entity.Alternative;
import com.decisionsupport.domain.entity.Criterion;
import com.decisionsupport.utils.GuidGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denisvieira on 04/01/17.
 */
public class AhpDashboardFragment extends Fragment implements AhpDashboardContract.View{

    private AhpDashboardContract.Presenter mPresenter;
    private AhpDashboardFragBinding mAhpDashboardFragBinding;
    private AhpDashboardAlternativeAdapter mAhpDashboardAlternativeAdapter;
    private AhpDashboardCriterionAdapter mAhpDashboardCriterionAdapter;
    private Dialog addCriterionDialog;
    private Dialog addAlternativeDialog;
    private AhpDashboardAddCriterionDialogBinding mAhpDashboardAddCriterionDialogBinding;
    private AhpDashboardAddAlternativeDialogBinding mAhpDashboardAddAlternativeDialogBinding;


    public AhpDashboardFragment() {}

    public static AhpDashboardFragment newInstance() {
        return new AhpDashboardFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
//        List<Criterion> criterionList = new ArrayList<>();
//        List<Alternative> alternativeList= new ArrayList<>();
//        for (int x=0; x<5;x++){
//            Criterion criterion = new Criterion(GuidGenerator.generate(),"Criterion "+x);
//            Alternative alternative = new Alternative(GuidGenerator.generate(), "Alternative "+x);
//            criterionList.add(criterion);
//            alternativeList.add(alternative);
//        }

        mAhpDashboardAlternativeAdapter = new AhpDashboardAlternativeAdapter( new ArrayList<Alternative>(0),getContext(),this);
        mAhpDashboardCriterionAdapter = new AhpDashboardCriterionAdapter( new ArrayList<Criterion>(0),getContext(),this);
//
//        mAhpDashboardAlternativeAdapter.replaceData(alternativeList);
//        mAhpDashboardCriterionAdapter.replaceData(criterionList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mAhpDashboardFragBinding = DataBindingUtil.inflate(inflater, R.layout.ahp_dashboard_frag,container,false);
        mAhpDashboardFragBinding.setHandler(this);

        if (mAhpDashboardFragBinding.ahpDashboardToolbar != null){
            ((AppCompatActivity) getActivity()).setSupportActionBar(mAhpDashboardFragBinding.ahpDashboardToolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
            mAhpDashboardFragBinding.ahpDashboardToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_left));
            mAhpDashboardFragBinding.ahpDashboardToolbar.setNavigationOnClickListener(View ->{
                getActivity().onBackPressed();
            });
        }

//        mAhpDashboardFragBinding.ahpDashboardStartButton.setOnClickListener(view ->{
//            Intent intent = new Intent(getContext(), AhpStepperActivity.class);
//            startActivity(intent);
//        });
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView.LayoutManager layout2 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mAhpDashboardFragBinding.ahpDashboardAlternativesListRecyclerView.setLayoutManager(layout);
        mAhpDashboardFragBinding.ahpDashboardAlternativesListRecyclerView.setNestedScrollingEnabled(false);
        mAhpDashboardFragBinding.ahpDashboardAlternativesListRecyclerView.setFocusable(false);
        mAhpDashboardFragBinding.ahpDashboardAlternativesListRecyclerView.setAdapter(mAhpDashboardAlternativeAdapter);

        mAhpDashboardFragBinding.ahpDashboardCriterionsListRecyclerView.setLayoutManager(layout2);
        mAhpDashboardFragBinding.ahpDashboardCriterionsListRecyclerView.setNestedScrollingEnabled(false);
        mAhpDashboardFragBinding.ahpDashboardCriterionsListRecyclerView.setFocusable(false);
        mAhpDashboardFragBinding.ahpDashboardCriterionsListRecyclerView.setAdapter(mAhpDashboardCriterionAdapter);


        checkListsContent();
        configDialogs();

        setHasOptionsMenu(true);
        return mAhpDashboardFragBinding.getRoot();
    }

    @Override
    public void checkListsContent(){
        if(mAhpDashboardAlternativeAdapter.getItemCount() > 0){
            mAhpDashboardFragBinding.ahpDashboardNoAlternativesTextView.setVisibility(View.GONE);
        }

        if(mAhpDashboardCriterionAdapter.getItemCount() > 0){
            mAhpDashboardFragBinding.ahpDashboardNoCriterionsTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public void startNew() {

    }

    @Override
    public void addCriterion(View view) {
        String criterionTitle = mAhpDashboardAddCriterionDialogBinding.ahpDashboardCriterionValueEditText.getText().toString();
        mAhpDashboardAddCriterionDialogBinding.ahpDashboardCriterionValueEditText.setText("");
        if(!criterionTitle.equals(""))
            mAhpDashboardCriterionAdapter.addItem(criterionTitle);

        addCriterionDialog.cancel();
    }

    @Override
    public void addAlternative(View view) {
        String alternativeTitle = mAhpDashboardAddAlternativeDialogBinding.ahpDashboardAlternativeValueEditText.getText().toString();
        mAhpDashboardAddAlternativeDialogBinding.ahpDashboardAlternativeValueEditText.setText("");
        if(!alternativeTitle.equals(""))
            mAhpDashboardAlternativeAdapter.addItem(alternativeTitle);

        addAlternativeDialog.cancel();
    }

    @Override
    public void openAddCriterionDialog(View view) {
        addCriterionDialog.show();
    }

    @Override
    public void closeAddCriterionDialog(View view) {
        addCriterionDialog.cancel();
    }

    @Override
    public void openAddAlternativeDialog(View view) {
        addAlternativeDialog.show();
    }

    @Override
    public void closeAddAlternativeDialog(View view) {
        addAlternativeDialog.cancel();
    }

    @Override
    public void setPresenter(AhpDashboardContract.Presenter presenter) {}

    public void configDialogs(){

        addAlternativeDialog = new Dialog(getContext(), R.style.DialogTheme);
        addAlternativeDialog.setTitle("ADD Alternative");
        mAhpDashboardAddAlternativeDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.ahp_dashboard_add_alternative_dialog, null, false);
        mAhpDashboardAddAlternativeDialogBinding.setHandler(this);
        addAlternativeDialog.setContentView(mAhpDashboardAddAlternativeDialogBinding.getRoot());

        addCriterionDialog = new Dialog(getContext(), R.style.DialogTheme);
        addCriterionDialog.setTitle("ADD CRITERION");
        mAhpDashboardAddCriterionDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.ahp_dashboard_add_criterion_dialog, null, false);
        mAhpDashboardAddCriterionDialogBinding.setHandler(this);
        addCriterionDialog.setContentView(mAhpDashboardAddCriterionDialogBinding.getRoot());
    }
}
