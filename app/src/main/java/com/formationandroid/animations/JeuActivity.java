package com.formationandroid.animations;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class JeuActivity extends AppCompatActivity implements View.OnTouchListener
{
	
	// Vues :
	private ConstraintLayout constraintLayoutMain = null;
	private ImageView imageViewPierre = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init :
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jeu);
		
		// vues :
		constraintLayoutMain = findViewById(R.id.main);
		imageViewPierre = findViewById(R.id.pierre);
		
		// listeners :
		constraintLayoutMain.setOnTouchListener(this);
	}
	
	@Override
	public boolean onTouch(View view, MotionEvent event)
	{
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			// positionnement initial :
			imageViewPierre.clearAnimation();
			imageViewPierre.setTranslationY(0);
			
			// calcul de la position de fin :
			float translationYFin = (event.getY() - imageViewPierre.getY()) * getResources().getInteger(R.integer.jeu_facteur_acceleration);
			
			// animation :
			ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewPierre, "translationY", 0, translationYFin);
			animator.setInterpolator(new DecelerateInterpolator());
			animator.setDuration(getResources().getInteger(R.integer.jeu_duree_animation));
			animator.start();
			
			return true;
		}
		return false;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// gestion du cas où l'utilisateur clique sur le bouton retour dans l'action bar :
		if (item.getItemId() == android.R.id.home)
		{
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void finish()
	{
		// fermeture de l'actvitité courante :
		super.finish();
		
		// animation de retour personnalisée :
		overridePendingTransition(R.anim.page_slide_vertical_out, R.anim.page_slide_vertical_back);
	}
	
}
