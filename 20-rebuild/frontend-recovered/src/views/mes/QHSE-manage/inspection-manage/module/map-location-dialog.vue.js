import { A as E } from "../../../../../modules/index-df3c71c0.js";
import { d as D } from "../../../../../modules/inspection-manage-c10227da.js";
import { u as S, mO as x } from "../../../../../shared/runtime.js";
import { ref as c } from "vue";
import { watch as G } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as H } from "vue";
import { createBlock as O } from "vue";
import { withCtx as K } from "vue";
import { createElementVNode as y } from "vue";
import { unref as w } from "vue";
import { isRef as j } from "vue";
const N = { __name: "map-location-dialog", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, point: { type: String, default: "" } }, emits: ["update:visible"], setup(M, { emit: k }) {
  const _ = c([]), C = c([]), b = c([]), u = c(), m = c(), A = k, l = M, { visible: r, handleClose: T } = S({ emit: A, props: l, field: "visible" });
  G(() => l.visible, (o) => {
    o && h();
  });
  async function h() {
    try {
      const o = await D({ type: x.JS.V }) || {};
      console.log(o, "DATA"), u.value = o == null ? void 0 : o.key, m.value = o == null ? void 0 : o.secret, V(u.value, m.value);
    } catch (o) {
      console.log("获取访问key值失败", o);
    }
  }
  function V(o, i) {
    window._AMapSecurityConfig = { securityJsCode: i }, E.load({ key: o, version: "2.0", plugins: ["AMap.ToolBar", "AMap.Scale", "AMap.HawkEye", "AMap.Geolocation", "AMap.MapType", "AMap.MouseTool"] }).then((e) => {
      var g, f, v;
      const a = new e.Map("container", { viewMode: "3D", zoom: 13 });
      e.plugin(["AMap.ToolBar", "AMap.Marker", "AMap.Scale", "AMap.HawkEye", "AMap.Geolocation", "AMap.MapType", "AMap.MouseTool", "AMap.ElasticMarker"], function() {
        var t = new e.ToolBar();
        a.addControl(t), a.addControl(new e.Scale()), a.addControl(new e.HawkEye()), a.plugin("AMap.Geolocation", function() {
          var n = new e.Geolocation({ enableHighAccuracy: true, timeout: 1e4, buttonOffset: new e.Pixel(10, 20), zoomToAccuracy: true });
          n.getCurrentPosition();
          function p(d) {
            console.log(d.message, "message");
          }
          function s(d) {
            console.log(d.message, "111");
          }
          e.Event.addListener(n, "complete", p), e.Event.addListener(n, "error", s), a.addControl(n);
        }), a.addControl(new e.MapType());
      }), a.on("click", (t) => {
        b.value = [t.lnglat.lng, t.lnglat.lat], C.value.push([t.lnglat.lng, t.lnglat.lat]);
      }), e.plugin("AMap.Geocoder", function() {
        var n;
        var t = new e.Geocoder({ city: "全国" });
        l.point && !((n = l.detailData) != null && n.point) && t.getLocation(l.point, function(p, s) {
          p === "complete" && s.info === "OK" && a.setCenter([s.geocodes[0].location.lng, s.geocodes[0].location.lat]);
        });
      });
      function B(t) {
        console.log("添加标记", t);
        const n = new e.Marker({ position: t, content: '<div class="custom-content-marker"><img src="//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-red.png" /></div>' });
        n.setMap(a), _.value.push(n);
      }
      if ((g = l.detailData) != null && g.point) {
        const t = (v = (f = l.detailData) == null ? void 0 : f.point) == null ? void 0 : v.split(",");
        a.setCenter(t), B(t);
      }
    }).catch((e) => {
      console.log(e);
    });
  }
  return (o, i) => {
    const e = L("common-dialog");
    return H(), O(e, { title: "巡检记录", modelValue: w(r), "onUpdate:modelValue": i[0] || (i[0] = (a) => j(r) ? r.value = a : null), width: "1000px", "before-close": w(T) }, { default: K(() => i[1] || (i[1] = [y("div", null, [y("div", { id: "container" })], -1)])), _: 1, __: [1] }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  N as default
};
