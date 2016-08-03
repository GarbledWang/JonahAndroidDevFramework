package com.jonah.data.model;

import com.jonah.data.dto.Code;
import com.jonah.data.misc.EndPoint;
import com.jonah.data.service.JonahFactory;
import com.jonah.data.service.JonahService;

import rx.Observable;

/**
 * @author JonahWang
 *         Created by JonahWang on 2016/7/11.
 */
public class JonahModel {
    public static JonahService service = JonahFactory.createService(JonahService.class, EndPoint.JONAH_URL);

    public static Observable<Code> getCode(String phone){
        return service.getCode(phone).compose(RxUtil.transform());
    }
}
