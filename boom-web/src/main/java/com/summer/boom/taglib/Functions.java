package com.summer.boom.taglib;

import boom.authority.controller.vo.ResourceVo;
import com.alibaba.fastjson.JSON;
import com.summer.base.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/6/26 下午3:33
 * @Description 前端标签工具集合
 */
public class Functions {
    private static final Logger LOG = LoggerFactory.getLogger(Functions.class);

    /**
     * 初始化资源列表
     * @param resourceVos
     * @return {@java.lang.String}
     */
    public static String iniResource(List<ResourceVo> resourceVos) {
//        LOG.error(JSON.toJSONString(resourceVos,true));
        String html = "<ul class='nav nav-list'>\n\t";
        html += "<li class='active'><a href='main.html'>\n\t<i class='icon-dashboard'></i><span class='menu-text'>Boom控制台></span></a></li>\n\t";
        if (null != resourceVos && resourceVos.size() > 0) {
            for (ResourceVo resourceVo : resourceVos) {
                html += iterateResource(resourceVo);
            }
        }
        html += "</ul>";
//        LOG.info("hmtl: " + html);
        return html;
    }

    private static String iterateResource(ResourceVo resourceVo) {
        String html = "";

        if (null != resourceVo) {
            html += "<li>";
            if (resourceVo.getType() == ResourceVo.DIRECTORY) {
                html += "<a href='#' class='dropdown-toggle'>\n\t";
                html += "<span class='menu-text'>" + resourceVo.getName() + "</span>\n\t";
                html += "<b class='arrow icon-angle-down'></b>\n\t";
                html += "</a>\n\t";
                List<ResourceVo> subResourceVos = resourceVo.getSubResources();
//                LOG.error(JSON.toJSONString(subResourceVos,true));
//                LOG.error("------------------------------------------------");
                if (!ObjectUtils.isEmptyList(subResourceVos)) {
                    html += "<ul class='submenu'>";
                    try {
                        for (ResourceVo subResourceVo : subResourceVos) {
                            html += iterateResource(subResourceVo);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    html += "</ul>";
                }

            } else if (resourceVo.getType() == ResourceVo.MENU) {
                html += "<a href='" + resourceVo.getUrl() + "'>\n\t";
                html += "<i class='icon-double-angle-right'></i>\n";
                html += resourceVo.getName();
                html += "</a>";
            }

            html += "</li>";
        }

        return html;
    }

}
