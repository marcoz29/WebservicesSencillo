package com.example.webservicessencillo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
EditText Id, txtNombre, txtApellido, txtEdad, txtTelefono, txtCorreo;
Button btnIngresar;

//RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Id = (EditText) findViewById(R.id.Id);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtCorreo = (EditText) findViewById(R.id.txtcorreo);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutaServicio(URL:"http://192.168.100.94:3307/marco_bd/insertar_producto.php");
            }
        });
    }
        private void ejecutaServicio (String URL){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), "Operacion Exitosa", Toast.LENGTH_SHORT).show();
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parametros = new HashMap<String, String>();
                    parametros.put("id", Id.getText().toString());
                    parametros.put("Nombre", txtNombre.getText().toString());
                    parametros.put("Apellido", txtApellido.getText().toString());
                    parametros.put("Edad", txtEdad.getText().toString());
                    parametros.put("Telefono", txtTelefono.getText().toString());
                    parametros.put("Correo", txtCorreo.getText().toString());
                    return parametros;
                }
            };
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }
    }
    //public void validar(View v){

        //final String nombre=e1.getText().toString();
        //final String apellido=e2.getText().toString();
        //final String edad=e3.getText().toString();
        //final String telefono=e4.getText().toString();
        //final String correo=e5.getText().toString();



        //String url="http://192.168.1.67/datos/ingreso.php?nombre="+nombre+"&apellido="+apellido+"&direccion="+direccion+"&telefono="+telefono+"&correo="+correo;
        //RequestQueue servicio= Volley.newRequestQueue(this);
        //StringRequest respuesta=new StringRequest(
                //Request.Method.GET, url, new Response.Listener<String>() {
           // @Override
           // public void onResponse(String response) {
             //   Toast.makeText(getApplicationContext(),
               //         response,Toast.LENGTH_LONG).show();


            //}
//        }, new Response.ErrorListener() {
  //          @Override
    //        public void onErrorResponse(VolleyError error) {
      //          Toast.makeText(getApplicationContext(),
        //                "Error comunicación",Toast.LENGTH_SHORT).show();
          //  }
        //});
        //servicio.add(respuesta);
   // }

   // public void buscarUsuarios(String URL){
        //JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            //@Override
           // public void onResponse(JSONArray response) {
               // JSONObject jsonObject = null;
               // for (int i = 0; i < response.length(); i++) {
                  //  try {
                    //    jsonObject = response.getJSONObject(i);
                     //   e1.setText(jsonObject.getString("nombre"));
                       // e2.setText(jsonObject.getString("apellido"));
                        //e3.setText(jsonObject.getString("direccion"));
                     //   e4.setText(jsonObject.getString("telefono"));
                       // e5.setText(jsonObject.getString("correo"));
                        //e6.setText(jsonObject.getString("sexo"));

//                    } catch (JSONException e) {
  //                      Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    //                }
      //          }

        //    }
      //  }, new Response.ErrorListener() {
            //@Override
            //public void onErrorResponse(VolleyError error) {
           // }
        //}
       // );
        //requestQueue=Volley.newRequestQueue(this);
        //requestQueue.add(jsonArrayRequest);

    //}
    //public void regresar(View view) {
       // Intent i = new Intent(this, MainActivity.class);
       // startActivity(i);
   // }
       // }
