package com.formationandroid.animations;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init :
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// vues :
		Button buttonJeu = findViewById(R.id.bouton_jeu);
		
		// animation initiale :
		buttonJeu.animate()
				.translationY(0)
				.alpha(1)
				.setDuration(getResources().getInteger(R.integer.main_duree_animation))
				.setInterpolator(new BounceInterpolator())
				.withLayer();
	}
	
	/**
	 * Listener clic bouton lancer jeu.
	 * @param view Bouton
	 */
	public void onClickLancerJeu(View view)
	{
		// lancement de l'activité de jeu :
		Intent intent = new Intent(this, JeuActivity.class);
		startActivity(intent);
		
		// animation de transition personnalisée :
		overridePendingTransition(R.anim.page_slide_vertical_in, R.anim.page_slide_vertical_out);
	}
	
}
