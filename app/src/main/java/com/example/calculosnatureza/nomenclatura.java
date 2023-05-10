package com.example.calculosnatureza;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class nomenclatura extends Fragment {
    EditText quantidadeCarbonos, tipoLigacao, grupoFuncional;
    TextView resultado;
    Button nomear;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public nomenclatura() {
    }

    public static nomenclatura newInstance(String param1, String param2) {
        nomenclatura fragment = new nomenclatura();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nomenclatura, container, false);
        quantidadeCarbonos = v.findViewById(R.id.numeroCarbonos);
        tipoLigacao = v.findViewById(R.id.tipoLigacao);
        grupoFuncional = v.findViewById(R.id.grupoFuncional);
        resultado = v.findViewById(R.id.resultado3);
        nomear = v.findViewById(R.id.nomear);
        nomear.setOnClickListener(sla -> juntaTudo());
        return v;
    }
    public void juntaTudo(){
        try{
            int nCarb = Integer.parseInt(quantidadeCarbonos.getText().toString());
            String numeroC = "";
            if (nCarb == 1) {
                numeroC = "Met";
            }
            else if (nCarb == 2){
                numeroC = "Et";
            }
            else if (nCarb == 3){
                numeroC = "Prop";
            }
            else if (nCarb == 4){
                numeroC = "But";
            }
            else if (nCarb == 5){
                numeroC = "Pent";
            }
            else if (nCarb == 6){
                numeroC = "Hex";
            }
            else if (nCarb == 7){
                numeroC = "Hept";
            }
            else if (nCarb == 8){
                numeroC = "Oct";
            }
            else if (nCarb == 9){
                numeroC = "Non";
            }
            else if (nCarb == 10){
                numeroC = "Dec";
            }
            String tipo = String.valueOf(tipoLigacao.getText());
            String tipoL = "";
            if (tipo == "Simples"){
                tipoL = "an";
            }
            else if(tipo == "Dupla"){
                tipoL = "en";
            }
            else if(tipo == "Tripla"){
                tipoL = "in";
            }
            else if(tipo == "Duas duplas"){
                tipoL = "dien";
            }
            else if(tipo == "Três duplas"){
                tipoL = "trien";
            }
            else if(tipo == "Duas Triplas"){
                tipoL = "din";
            }
            else if(tipo == "Três triplas"){
                tipoL = "trin";
            }

            String grupoF = String.valueOf(grupoFuncional.getText());
            String grupo = "";
            if (grupoF == "Hidrocarboneto"){
                grupo = "o";
            }
            else if (grupoF == "Álcool"){
                grupo = "ol";
            }
            else if (grupoF == "Aldeido"){
                grupo = "al";
            }
            else if (grupoF == "Ácido Carboxílico"){
                grupo = "óico";
            }
            else if (grupoF == "Cetona"){
                grupo = "ona";
            }
            else if (grupoF == "Amina"){
                grupo = "amina";
            }
            else if (grupoF == "Amida"){
                grupo = "amida";
            }
            String res = ""+numeroC+ ""+tipoL+""+grupo;
            resultado.setText(res);
        }
        catch (Exception e){
            Toast.makeText(getContext(), "Por favor insira um valor válido", Toast.LENGTH_SHORT).show();
        }
    }
}