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

public class campoEletrico extends Fragment {
    TextView resultado;
    EditText forcaEletrica, cargaEletrica;
    Button calcula;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public campoEletrico() {

    }

    public static campoEletrico newInstance(String param1, String param2) {
        campoEletrico fragment = new campoEletrico();
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
        View v = inflater.inflate(R.layout.fragment_campo_eletrico, container, false);
        cargaEletrica = v.findViewById(R.id.cargaEletrica);
        forcaEletrica = v.findViewById(R.id.forcaEletrica);
        resultado = v.findViewById(R.id.resultado);
        calcula = v.findViewById(R.id.calcula);
        calcula.setOnClickListener(sla -> calcular());
        return v;
    }
    public void calcular(){
        try {
            double f = Double.parseDouble(forcaEletrica.getText().toString());
            double q = Double.parseDouble(cargaEletrica.getText().toString());
            double res = f / q;
            String resString = String. valueOf(res);
            resultado.setText("O resultado é " + resString);
        }
        catch (Exception e){
            Toast.makeText(getContext(), "Por favor insira um valor válido", Toast.LENGTH_SHORT).show();
        }
    }
}