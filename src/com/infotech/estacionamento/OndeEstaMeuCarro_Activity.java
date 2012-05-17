package com.infotech.estacionamento;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class OndeEstaMeuCarro_Activity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.locais);
		Button salvar = (Button) this.findViewById(R.id.salvar);
		Button foto = (Button) this.findViewById(R.id.foto);
		salvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				CarroLocal carro = new CarroLocal();
				carro.setNome(getNomeDoField());
				carro.setPiso(getPisoDoField());

				Toast.makeText(OndeEstaMeuCarro_Activity.this,
						carro.getNome() + " Salvo com sucesso",
						Toast.LENGTH_SHORT).show();
			}
		});

		foto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				OndeEstaMeuCarro_Activity.this.startActivityForResult(intent,
						120);
			}
		});
	}

	protected String getPisoDoField() {
		return ((EditText) findViewById(R.id.piso)).getText().toString();
	}

	public String getNomeDoField() {

		return ((EditText) findViewById(R.id.nome)).getText().toString();
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			Bitmap foto = (Bitmap) data.getExtras().get("data");
			((ImageView) findViewById(R.id.foto_img)).setImageBitmap(foto);
		}
	}

}