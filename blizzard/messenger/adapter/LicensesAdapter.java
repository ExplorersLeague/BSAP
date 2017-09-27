package com.blizzard.messenger.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blizzard.messenger.model.License;
import java.util.List;

public class LicensesAdapter
  extends RecyclerView.Adapter<LicenseViewHolder>
{
  private List<License> licenses;
  
  public LicensesAdapter(List<License> paramList)
  {
    this.licenses = paramList;
  }
  
  public int getItemCount()
  {
    return this.licenses.size();
  }
  
  public void onBindViewHolder(LicenseViewHolder paramLicenseViewHolder, int paramInt)
  {
    License localLicense = (License)this.licenses.get(paramInt);
    paramLicenseViewHolder.libraryAuthorTextView.setText(localLicense.getLibraryAuthor());
    paramLicenseViewHolder.libraryNameTextView.setText(localLicense.getLibraryName());
    paramLicenseViewHolder.licenseTypeTextView.setText(localLicense.getLicenseType());
  }
  
  public LicenseViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new LicenseViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130968651, null));
  }
  
  class LicenseViewHolder
    extends RecyclerView.ViewHolder
  {
    final TextView libraryAuthorTextView;
    final TextView libraryNameTextView;
    final TextView licenseTypeTextView;
    
    LicenseViewHolder(View paramView)
    {
      super();
      this.libraryAuthorTextView = ((TextView)paramView.findViewById(2131820808));
      this.libraryNameTextView = ((TextView)paramView.findViewById(2131820807));
      this.licenseTypeTextView = ((TextView)paramView.findViewById(2131820809));
    }
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/adapter/LicensesAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */