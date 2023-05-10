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

public class cargaEletrica extends Fragment {
    TextView resultado2;
    EditText quantidadeEletrons;
    Button calcula2;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public cargaEletrica() {

    }

    public static cargaEletrica newInstance(String param1, String param2) {
        cargaEletrica fragment = new cargaEletrica();
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
        View v = inflater.inflate(R.layout.fragment_carga_eletrica, container, false);
        quantidadeEletrons = v.findViewById(R.id.quantiaEletrons);
        resultado2 = v.findViewById(R.id.resultado2);
        calcula2 = v.findViewById(R.id.calcula2);
        calcula2.setOnClickListener(sla -> calcular());
        return v;
    }
    public void calcular(){
        try {
            double n = Double.parseDouble(quantidadeEletrons.getText().toString());
            double e = 1.6 * (Math.pow(10, -19));
            double res = n * e;
            String resString = String. valueOf(res);
            resultado2.setText("O resultado é " + resString);
        }
        catch (Exception e){
            Toast.makeText(getContext(), "Por favor insira um valor válido", Toast.LENGTH_SHORT).show();
        }
    }
}