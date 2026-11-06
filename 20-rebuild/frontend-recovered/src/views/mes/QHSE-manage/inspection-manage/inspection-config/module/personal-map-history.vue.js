import { A as C } from "../../../../../../modules/index-df3c71c0.js";
import { d as h } from "../../../../../../modules/inspection-manage-c10227da.js";
import { u as T, mO as x } from "../../../../../../shared/runtime.js";
import { ref as m } from "vue";
import { watch as V } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as B } from "vue";
import { createBlock as S } from "vue";
import { withCtx as H } from "vue";
import { createElementVNode as f } from "vue";
import { unref as w } from "vue";
import { isRef as G } from "vue";
const O = { __name: "personal-map-history", props: { visible: { type: Boolean, default: false }, personalRow: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(y, { emit: v }) {
  const c = m(), p = m(), g = v, i = y, { visible: l, handleClose: M } = T({ emit: g, props: i, field: "visible" });
  V(() => i.visible, async (o) => {
    o && await _();
  });
  async function _() {
    try {
      const o = await h({ type: x.JS.V }) || {};
      console.log(o, "DATA"), c.value = o == null ? void 0 : o.key, p.value = o == null ? void 0 : o.secret, b(c.value, p.value);
    } catch (o) {
      console.log("获取访问key值失败", o);
    }
  }
  function b(o, s) {
    window._AMapSecurityConfig = { securityJsCode: s }, C.load({ key: o, version: "2.0", plugins: ["AMap.ToolBar", "AMap.Scale", "AMap.HawkEye", "AMap.Geolocation", "AMap.MapType", "AMap.MouseTool", "AMap.InfoWindow"] }).then((e) => {
      var u, d;
      const n = new e.Map("container_personal", { viewMode: "3D", resizeEnable: true, zoom: 13 });
      e.plugin(["AMap.ToolBar", "AMap.Marker", "AMap.Scale", "AMap.HawkEye", "AMap.Geolocation", "AMap.MapType", "AMap.MouseTool", "AMap.InfoWindow"], function() {
        var a = new e.ToolBar();
        n.addControl(a), n.addControl(new e.Scale()), n.addControl(new e.HawkEye()), n.plugin("AMap.Geolocation", function() {
          var t = new e.Geolocation({ enableHighAccuracy: true, timeout: 1e4, buttonOffset: new e.Pixel(10, 20), zoomToAccuracy: true });
          t.getCurrentPosition();
          function k(r) {
            console.log(r.message, "message");
          }
          function A(r) {
            console.log(r.message, "111");
          }
          e.Event.addListener(t, "complete", k), e.Event.addListener(t, "error", A), n.addControl(t);
        }), n.addControl(new e.MapType());
      }), (d = (u = i.personalRow) == null ? void 0 : u.inspectionList) == null || d.forEach(function(a) {
        var t;
        a.position = a.point.split(","), new e.Marker({ map: n, content: `<div class="custom-content-marker"><img src="//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-red.png" /><div class="text-number">${(t = i.personalRow) != null && t.isSort ? a.sortNumber : ""}</div></div>`, position: a.position, offset: new e.Pixel(-13, -30), title: a.name });
      }), n.setFitView();
    }).catch((e) => {
      console.log(e);
    });
  }
  return (o, s) => {
    const e = E("common-dialog");
    return B(), S(e, { title: "巡检路线", modelValue: w(l), "onUpdate:modelValue": s[0] || (s[0] = (n) => G(l) ? l.value = n : null), width: "1000px", "before-close": w(M) }, { default: H(() => s[1] || (s[1] = [f("div", null, [f("div", { id: "container_personal", style: { width: "950px", height: "600px" } })], -1)])), _: 1, __: [1] }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  O as default
};
