import { A as G } from "../../../../../modules/index-df3c71c0.js";
import { u as N, o as Q, mO as W, au as j, aS as J } from "../../../../../shared/runtime.js";
import { a as K, g as O } from "../../../../../modules/inspection-config-a69d9e2f.js";
import { d as F } from "../../../../../modules/inspection-manage-c10227da.js";
import { ref as l } from "vue";
import { watch as R } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as q } from "vue";
import { createBlock as X } from "vue";
import { withCtx as Y } from "vue";
import { createElementVNode as L } from "vue";
import { normalizeStyle as Z } from "vue";
import { unref as w } from "vue";
import { isRef as ee } from "vue";
const se = { __name: "history-map-dialog", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(E, { emit: T }) {
  const V = l([]), B = l([]), H = l([]), v = l(), _ = l(), m = l([]), x = l([]), A = T, c = E, { visible: g, handleClose: I } = N({ emit: A, props: c, field: "visible" }), { maxHeight: S } = Q({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], minHeight: 300 }, g);
  R(() => c.visible, async (e) => {
    e && (await $(), await D(), await P());
  });
  async function $() {
    try {
      const e = await K();
      x.value = e || [];
    } catch (e) {
      console.log(e, "获取历史点位人员列表");
    }
  }
  async function D() {
    m.value = [];
    try {
      const e = await O();
      e == null || e.forEach((s, t) => {
        var a;
        s.index = t + 1, s.userList = [], (a = x.value) == null || a.forEach((n) => {
          var d, h;
          n.inspectionQuantity = (d = n.inspectionList) == null ? void 0 : d.length, ((h = n.inspectionList) == null ? void 0 : h.findIndex((f) => f.id === s.id)) > -1 && s.userList.push({ userName: n.userName, patrolsTime: n.patrolsTime, mandatoryInspection: n.mandatoryInspection, status: n.status, inspectionQuantity: n.inspectionQuantity });
        });
      }), m.value = e || [], console.log(m.value, "historyList.value");
    } catch (e) {
      console.log(e, "获取点位列表失败");
    }
  }
  async function P() {
    try {
      const e = await F({ type: W.JS.V }) || {};
      console.log(e, "DATA"), v.value = e == null ? void 0 : e.key, _.value = e == null ? void 0 : e.secret, z(v.value, _.value);
    } catch (e) {
      console.log("获取访问key值失败", e);
    }
  }
  function z(e, s) {
    window._AMapSecurityConfig = { securityJsCode: s }, G.load({ key: e, version: "2.0", plugins: ["AMap.ToolBar", "AMap.Scale", "AMap.HawkEye", "AMap.Geolocation", "AMap.MapType", "AMap.MouseTool", "AMap.InfoWindow"] }).then((t) => {
      var f, M, b, k, C;
      const a = new t.Map("container1", { viewMode: "3D", resizeEnable: true, zoom: 13 });
      t.plugin(["AMap.ToolBar", "AMap.Marker", "AMap.Scale", "AMap.HawkEye", "AMap.Geolocation", "AMap.MapType", "AMap.MouseTool", "AMap.InfoWindow"], function() {
        var o = new t.ToolBar();
        a.addControl(o), a.addControl(new t.Scale()), a.addControl(new t.HawkEye()), a.plugin("AMap.Geolocation", function() {
          var i = new t.Geolocation({ enableHighAccuracy: true, timeout: 1e4, buttonOffset: new t.Pixel(10, 20), zoomToAccuracy: true });
          i.getCurrentPosition();
          function p(r) {
            console.log(r.message, "message");
          }
          function y(r) {
            console.log(r.message, "111");
          }
          t.Event.addListener(i, "complete", p), t.Event.addListener(i, "error", y), a.addControl(i);
        }), a.addControl(new t.MapType());
      }), a.on("click", (o) => {
        H.value = [o.lnglat.lng, o.lnglat.lat], B.value.push([o.lnglat.lng, o.lnglat.lat]);
      });
      function n(o) {
        console.log("添加标记", o);
        const i = new t.Marker({ position: o, content: '<div class="custom-content-marker"><img src="//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-red.png" /></div>' });
        i.setMap(a), V.value.push(i);
      }
      if ((f = c.detailData) != null && f.point) {
        console.log((M = c.detailData) == null ? void 0 : M.point, "props.detailData?.point");
        const o = (k = (b = c.detailData) == null ? void 0 : b.point) == null ? void 0 : k.split(",");
        a.setCenter(o), n(o);
      }
      var d = new t.InfoWindow({ offset: new t.Pixel(0, -30) });
      (C = m.value) == null || C.forEach(function(o) {
        var r;
        o.position = o.point.split(",");
        var i = new t.Marker({ map: a, content: `<div class="custom-content-marker"><img src="//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-red.png" /><div class="text-number">${o.index}</div></div>`, position: o.position, offset: new t.Pixel(-13, -30) });
        let p = "";
        (r = o.userList) == null || r.forEach((u) => {
          p = p + `
                              <tr>
                                <td>${u.userName}</td>
                                <td>${u.inspectionQuantity}</td>
                                <td>${u.patrolsTime}</td>
                                <td>${j.VL[u.mandatoryInspection]}</td>
                                <td>${J.VL[u.status]}</td>
                              </tr>
                              `;
        });
        const y = ` <div style='width: 380px;padding:5px 10px;'>
                            <table border="1" cellspacing="0" cellpadding="1">
                              <tr>
                                <th width="80">责任人</th>
                                <th width="60">巡检点</th>
                                <th width="80">巡检次数</th>
                                <th width="80">强制巡检</th>
                                <th width="60">状态</th>
                              <tr>
                                ${p}
                            </table>
                            </div>
                              `;
        i.content = y, i.on("mouseover", h);
      });
      function h(o) {
        d.setContent(o.target.content), d.open(a, o.target.getPosition());
      }
      a.setFitView();
    }).catch((t) => {
      console.log(t);
    });
  }
  return (e, s) => {
    const t = U("common-dialog");
    return q(), X(t, { title: "巡检点历史分布", modelValue: w(g), "onUpdate:modelValue": s[0] || (s[0] = (a) => ee(g) ? g.value = a : null), width: "1000px", top: "3vh", "before-close": w(I) }, { default: Y(() => [L("div", null, [L("div", { id: "container1", style: Z(`width: 950px; height: ${w(S) - 40}px`) }, null, 4)])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  se as default
};
