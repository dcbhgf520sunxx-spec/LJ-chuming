import { ref as c } from "vue";
import { watch as v } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as I } from "vue";
import { normalizeStyle as x } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as b } from "vue";
import { createVNode as S } from "vue";
import { Fragment as q } from "vue";
import { vLoading as C } from "element-plus";
import { e as M } from "../../../modules/production-performance-dashboard-bb1cff92.js";
import { u as O } from "../../../modules/use-chart-59e4b63c.js";
import j from "./target-yield-rate-detail.vue.js";
import "../../../shared/runtime.js";
import "../../../modules/index-18acf776.js";
const D = { style: { display: "flex", "justify-content": "space-around" } }, N = { style: { color: "#67c23a" } }, _ = { __name: "target-yield-rate", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, productWorkshopId: { type: Number }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(l) {
  const n = c(), f = c(false), h = c(false), e = c({}), u = l, { getMyChart: w } = O({ elementId: "targetYieldRateChart", fetchHook: m, initOption: { legend: { show: false }, tooltip: { trigger: "item", show: false }, title: { text: "目标产量达成率", textStyle: { fontStyle: "normal", fontWeight: "bold", fontFamily: "sans-serif", fontSize: 12 } }, series: [{ type: "pie", radius: ["40%", "70%"], backgroundColor: "#dcdfe6", label: { show: true, position: "center", formatter: "{c}%", fontSize: 16, fontWeight: "bold" }, data: [{ value: 40, precision: 2, label: { normal: { show: true } } }, { value: 60, precision: 2, itemStyle: { color: "#f1f1f1" }, label: { normal: { show: false } } }] }] } });
  v(() => u.query, (o) => {
    m();
  }, { deep: true }), v(() => u.productWorkshopId, (o) => {
    o ? n.value = o : n.value = u.query.workshopId || void 0, m();
  });
  async function m(o) {
    var a, d, s, i;
    try {
      f.value = true;
      const t = o || w(), r = t.getOption(), k = await M({ ...u.query, workshopId: n.value });
      e.value = k || {}, r.series[0].data[0].value = (a = e.value) != null && a.target && ((d = e.value) != null && d.completeMete) ? (((s = e.value) == null ? void 0 : s.completeMete) / ((i = e.value) == null ? void 0 : i.target) * 100).toFixed(2) : 0, r.series[0].data[1].value = 100 - r.series[0].data[0].value, t.setOption(r), t.on("click", function(W) {
        h.value = true;
      });
    } catch (t) {
      console.log(t, "获取目标达成率失败");
    } finally {
      f.value = false;
    }
  }
  return (o, a) => {
    var s, i, t;
    const d = C;
    return y(), g(q, null, [I((y(), g("div", { style: x({ height: l.maxHeight + "px" }) }, [a[1] || (a[1] = p("div", { id: "targetYieldRateChart", style: { width: "100%", height: "90%" } }, null, -1)), p("div", D, [p("span", null, "目标： " + b((s = e.value) != null && s.target ? Math.round(e.value.target) : 0) + "吨", 1), p("span", N, "完成： " + b((i = e.value) != null && i.completeMete ? Math.round(e.value.completeMete) : 0) + "吨", 1)])], 4)), [[d, f.value]]), S(j, { visible: h.value, "onUpdate:visible": a[0] || (a[0] = (r) => h.value = r), query: l.query, workshopId: n.value, detailData: e.value, branchInfo: l.branchInfo, permission: (t = l.permission) == null ? void 0 : t.workshopMete }, null, 8, ["visible", "query", "workshopId", "detailData", "branchInfo", "permission"])], 64);
  };
} };
export {
  _ as default
};
