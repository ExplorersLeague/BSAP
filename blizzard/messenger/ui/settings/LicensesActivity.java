package com.blizzard.messenger.ui.settings;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.blizzard.messenger.adapter.LicensesAdapter;
import com.blizzard.messenger.databinding.LicensesActivityBinding;
import com.blizzard.messenger.model.License;
import com.blizzard.messenger.ui.base.BaseActivity;
import com.blizzard.messenger.utils.AnimUtils;
import com.blizzard.messenger.utils.ColorUtils;
import com.google.firebase.perf.metrics.AppStartTrace;
import java.util.ArrayList;
import java.util.List;

public class LicensesActivity
  extends BaseActivity
{
  private LicensesActivityBinding binding;
  
  private List<License> getLicenses()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1 = getResources().getStringArray(2131755011);
    String[] arrayOfString2 = getResources().getStringArray(2131755009);
    String[] arrayOfString3 = getResources().getStringArray(2131755010);
    int i = 0;
    while (i < arrayOfString1.length - 1)
    {
      localArrayList.add(new License(arrayOfString1[i], arrayOfString2[i], arrayOfString3[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  private void setupRecyclerView()
  {
    Object localObject2 = getLicenses();
    Object localObject1 = new LinearLayoutManager(this);
    ((LinearLayoutManager)localObject1).setOrientation(1);
    this.binding.recyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject1);
    localObject2 = new LicensesAdapter((List)localObject2);
    this.binding.recyclerView.setHasFixedSize(true);
    localObject1 = new DividerItemDecoration(this.binding.recyclerView.getContext(), ((LinearLayoutManager)localObject1).getOrientation());
    ((DividerItemDecoration)localObject1).setDrawable(ContextCompat.getDrawable(this, 2130837739));
    this.binding.recyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject1);
    this.binding.recyclerView.setAdapter((RecyclerView.Adapter)localObject2);
    this.binding.recyclerView.setLayoutAnimation(AnimUtils.getRecyclerViewAnimationController());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppStartTrace.setLauncherActivityOnCreateTime("com.blizzard.messenger.ui.settings.LicensesActivity");
    super.onCreate(paramBundle);
    this.binding = ((LicensesActivityBinding)DataBindingUtil.setContentView(this, 2130968650));
    this.binding.toolbar.setTitleTextColor(ColorUtils.getTextColorActionBarTitle(this));
    setSupportActionBar(this.binding.toolbar);
    setTitle(getString(2131361943));
    setDisplayHomeAsUpEnabled(true);
    setHomeButtonEnabled(true);
    setupRecyclerView();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      finish();
    }
  }
  
  protected void onResume()
  {
    AppStartTrace.setLauncherActivityOnResumeTime("com.blizzard.messenger.ui.settings.LicensesActivity");
    super.onResume();
  }
  
  protected void onStart()
  {
    AppStartTrace.setLauncherActivityOnStartTime("com.blizzard.messenger.ui.settings.LicensesActivity");
    super.onStart();
  }
}


/* Location:              /Users/magni/Desktop/decompiled/bsap.jar!/com/blizzard/messenger/ui/settings/LicensesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */