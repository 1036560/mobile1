package net.charlesdelmaire.qingpool;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PopupActivity extends ListActivity {

	private String[] m_Tokens = {"À", "la", "claire", "fontaine", "m'en", "allant", "me", "promener", "J'ai", "trouvé", "l'eau", "si", "belle", "que", "je", "m'y", "suis", "baigné", "il", "y", "a", "longtemps", "que", "je", "t'aime", "jamais", "je", "ne", "t'oublierai"};
	
	private ArrayList<RowModel> m_RowModels = new ArrayList<RowModel>();
	
	private TextView lblChoice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.popupjoueur);
		
		this.lblChoice = (TextView) this.findViewById(R.id.viewjoueur);
		
		this.setListAdapter(new LigneAdapter());
		
		for (String token : m_Tokens) {
			m_RowModels.add(new RowModel(token));
		}
	}

	@Override
	protected void onListItemClick(ListView p_l, View p_row, int p_position, long p_id) {
		RowModel model = m_RowModels.get(p_position);
		this.lblChoice.setText(model.getContent());
		
		model.setIsToDelete(!model.isToDelete());
		
		ImageView icon = (ImageView) p_row.findViewById(R.id.img_selection);
		if (model.isToDelete()) {
			icon.setImageResource(R.drawable.ic_launcher);
		} else {
			icon.setImageResource(R.drawable.user);
		}
	}

	public class LigneAdapter extends ArrayAdapter<String> {

		public LigneAdapter() {
			super(PopupActivity.this, R.layout.row, R.id.lbl_content, m_Tokens);
		}
		
		@Override
		public View getView(int p_Position, View p_Row, ViewGroup p_List) {
			
			// Récupération d'une ligne à l'aide de la méthode de la classe mère.
			View row = super.getView(p_Position, p_Row, p_List);
			
			RowModel model = m_RowModels.get(p_Position);
			
			TextView lblContent = (TextView) row.findViewById(R.id.viewjoueur);
			lblContent.setText(model.getContent());
			
			ImageView icon = (ImageView) row.findViewById(R.id.img_selection);
			if (model.isToDelete()) {
				icon.setImageResource(R.drawable.ic_launcher);
			} else {
				icon.setImageResource(R.drawable.user);
			}

			return row;
		}
	}

	public static class RowModel {
	    private String  m_Content;
	    private boolean m_IsToDelete;

	    public RowModel(String content) {
	        this.m_Content  = content;
	        this.m_IsToDelete = false;
	    }
	    public String getContent() {
	        return m_Content;
	    }
	    public void setContent(String content) {
	        this.m_Content = content;
	    }
	    public boolean isToDelete() {
	        return m_IsToDelete;
	    }
	    public void setIsToDelete(boolean isToDelete) {
	        this.m_IsToDelete = isToDelete;
	    }
	}
}
