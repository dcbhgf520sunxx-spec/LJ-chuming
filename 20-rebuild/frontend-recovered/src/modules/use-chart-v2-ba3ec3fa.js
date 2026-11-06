import { i as x } from "./index-18acf776.js";
import { useStore as y } from "vuex";
import { onMounted as A } from "vue";
import { watch as z } from "vue";
import { onBeforeUnmount as v } from "vue";
function T({ elementId: h, fetchHook: l, initOption: e = {} }) {
  let r = null;
  const m = y();
  A(async () => {
    setTimeout(() => {
      g(h), typeof l == "function" && l(r);
    }), z(() => m.getters.sidebar.opened, () => {
      u();
    });
  });
  function d() {
    return r;
  }
  function g(s) {
    var c;
    var o = document.getElementById(s);
    if (!o) return;
    r = x(o, null, { locale: "ZH" });
    const w = { show: false, position: "insideBottom", distance: 15, align: "center", verticalAlign: "middle", rotate: 90, formatter: "{c}", color: "#fff", fontSize: 14, rich: { name: {} }, ...e == null ? void 0 : e.labelOption }, a = { title: { ...e == null ? void 0 : e.title }, tooltip: { show: true, ...e == null ? void 0 : e.tooltip }, grid: { right: "1%", left: "1%", bottom: 0, containLabel: true, ...e == null ? void 0 : e.grid }, toolbox: { show: false, orient: "horizontal", left: "right", top: "top", feature: { mark: { show: true }, dataView: { show: false }, magicType: { show: true, type: ["line", "bar"] }, restore: { show: false }, saveAsImage: { show: true }, ...e == null ? void 0 : e.toolboxFeature }, ...e == null ? void 0 : e.toolbox }, legend: { ...e == null ? void 0 : e.legend }, xAxis: [{ ...e == null ? void 0 : e.xAxis }], yAxis: [...e == null ? void 0 : e.yAxis], series: (c = e == null ? void 0 : e.series) == null ? void 0 : c.reduce((f, b) => (f.push({ label: w, emphasis: { focus: "series" }, ...b }), f), []), ...e.custom };
    console.log(a, "option"), a && r.setOption(a);
  }
  function u() {
    r && setTimeout(() => {
      try {
        r.resize();
      } catch (s) {
        console.error("图表重绘失败:", s);
      }
    }, 300);
  }
  return window.addEventListener("resize", function() {
    u();
  }), v(() => {
    r && (r.dispose(), r = null);
  }), { getMyChart: d };
}
export {
  T as u
};
