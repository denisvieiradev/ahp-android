package com.decisionsupport.ahpmethod.AhpSteps;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.decisionsupport.domain.entity.AhpMethod;
import com.decisionsupport.domain.entity.Alternative;
import com.decisionsupport.domain.entity.Criterion;
import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.github.fcannizzaro.materialstepper.style.DotStepper;

import java.util.List;

/**
 * Created by denisvieira on 04/01/17.
 */
public class AhpStepperActivity extends DotStepper {

    private int i = 1;
    private AlertDialog alertDialog;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setErrorTimeout(1500);
        setTitle("Seleção de Preferências");

        Intent intent = getIntent();
        AhpMethod ahpMethod = (AhpMethod) intent.getSerializableExtra("ahpBundle");

        List<Alternative> alternatives = ahpMethod.getAlternatives();
        List<Criterion> criterions = ahpMethod.getCriterions();

        addStep(createFragment(new InitialStep()));
        addStep(createFragment(new CriterionOneStep(alternatives, criterions.get(0))));
        addStep(createFragment(new CriterionOneStep(alternatives, criterions.get(1))));
        addStep(createFragment(new CriterionOneStep(alternatives, criterions.get(2))));
        addStep(createFragment(new CriterionOneStep(alternatives, criterions.get(3))));

        configureAlertDialogOnBackPressed();

        super.onCreate(savedInstanceState);
    }

    private void configureAlertDialogOnBackPressed(){
        alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Tem certeza que deseja sair ? ");
        alertDialogBuilder.setMessage("Se continuar perderá todas as " +
                "informações que adicionou até agora .");

        alertDialogBuilder.setPositiveButton("SIM",
                (dialog, which) -> {
                    finish();
                });
        alertDialogBuilder.setNegativeButton("NÃO",
                (dialog, which) -> {
                    alertDialog.cancel();
                });
        alertDialog = alertDialogBuilder.create();
    }

    private AbstractStep createFragment(AbstractStep fragment) {
        Bundle b = new Bundle();
        b.putInt("position", i++);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onComplete() {
        super.onComplete();
        Toast.makeText(getApplicationContext(), "Completed Steps !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed(){
        alertDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (data != null && data.getExtras() != null)
            for (String key : data.getExtras().keySet())
                Toast.makeText(this, key + " : " + data.getExtras().get(key).toString(), Toast.LENGTH_SHORT).show();

        super.onActivityResult(requestCode, resultCode, data);

    }

}
