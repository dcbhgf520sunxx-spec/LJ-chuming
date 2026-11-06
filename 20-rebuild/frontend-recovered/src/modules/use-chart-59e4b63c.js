import { i as x } from "./index-18acf776.js";
import { useStore as b } from "vuex";
import { onMounted as A } from "vue";
import { watch as v } from "vue";
import { onBeforeUnmount as z } from "vue";
function B({ elementId: h, fetchHook: l, initOption: e = {} }) {
  let r = null;
  const d = b();
  A(async () => {
    setTimeout(() => {
      g(h), typeof l == "function" && l(r);
    }), v(() => d.getters.sidebar.opened, () => {
      o();
    });
  });
  function m() {
    return r;
  }
  function g(s) {
    var c;
    var u = document.getElementById(s);
    if (!u) return;
    r = x(u, null, { locale: "ZH" });
    const w = { show: false, position: "insideBottom", distance: 15, align: "center", verticalAlign: "middle", rotate: 90, formatter: "{c}", color: "#fff", fontSize: 14, rich: { name: {} }, ...e == null ? void 0 : e.labelOption }, a = { title: { ...e == null ? void 0 : e.title }, tooltip: { show: true, trigger: "axis", axisPointer: { type: "shadow" }, ...e == null ? void 0 : e.tooltip }, grid: { right: "1%", left: "1%", bottom: 0, containLabel: true, ...e == null ? void 0 : e.grid }, toolbox: { show: false, orient: "horizontal", left: "right", top: "top", feature: { mark: { show: true }, dataView: { show: false }, magicType: { show: true, type: ["line", "bar"] }, restore: { show: false }, saveAsImage: { show: true }, ...e == null ? void 0 : e.toolboxFeature }, ...e == null ? void 0 : e.toolbox }, legend: { ...e == null ? void 0 : e.legend }, xAxis: [{ type: "category", axisTick: { show: false }, ...e == null ? void 0 : e.xAxis }], yAxis: [{ type: "value", ...e == null ? void 0 : e.yAxis }], series: (c = e == null ? void 0 : e.series) == null ? void 0 : c.reduce((f, y) => (f.push({ label: w, emphasis: { focus: "series" }, ...y }), f), []), ...e.custom };
    console.log(a, "option"), a && r.setOption(a);
  }
  function o() {
    r && setTimeout(() => {
      try {
        r.resize();
      } catch (s) {
        console.error("图表重绘失败:", s);
      }
    }, 300);
  }
  return window.addEventListener("resize", function() {
    o();
  }), z(() => {
    r && (r.dispose(), r = null);
  }), { getMyChart: m };
}
export {
  B as u
};
