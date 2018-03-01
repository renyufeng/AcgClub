package com.rabtman.acgcomic.mvp

import com.rabtman.acgcomic.api.AcgComicService
import com.rabtman.acgcomic.mvp.model.entity.DmzjComicItem
import com.rabtman.acgcomic.mvp.model.entity.OacgComicDetail
import com.rabtman.acgcomic.mvp.model.entity.OacgComicPage
import com.rabtman.common.base.mvp.BaseModel
import com.rabtman.common.di.scope.ActivityScope
import com.rabtman.common.di.scope.FragmentScope
import com.rabtman.common.integration.IRepositoryManager
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @author Rabtman
 */
@FragmentScope
class DmzjComicModel @Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), DmzjComicContract.Model {

    override fun getComicInfos(selected: String): Flowable<List<DmzjComicItem>> {
        return mRepositoryManager.obtainRetrofitService(AcgComicService::class.java)
                .getDmzjComicList(selected)
    }

}

@FragmentScope
class OacgComicModel @Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), OacgComicContract.Model {

    override fun getComicInfos(themeId: Int, pageNo: Int): Flowable<OacgComicPage> {
        return mRepositoryManager.obtainRetrofitService(AcgComicService::class.java)
                .getOacgComicList(themeId, pageNo)
    }

}

@ActivityScope
class OacgComicDetailModel @Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), OacgComicDetailContract.Model {
    override fun getComicDetail(comicId: Int): Flowable<List<OacgComicDetail>> {
        return mRepositoryManager.obtainRetrofitService(AcgComicService::class.java)
                .getOacgComicDetail(comicId)
    }
}