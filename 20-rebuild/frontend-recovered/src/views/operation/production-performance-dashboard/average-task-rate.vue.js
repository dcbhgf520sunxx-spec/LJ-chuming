import { ref as u } from "vue";
import { watch as v } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as k } from "vue";
import { withDirectives as b } from "vue";
import { normalizeStyle as w } from "vue";
import { createElementVNode as I } from "vue";
import { createVNode as q } from "vue";
import { Fragment as x } from "vue";
import { vLoading as S } from "element-plus";
import { b as C } from "../../../modules/production-performance-dashboard-bb1cff92.js";
import { u as O } from "../../../modules/use-chart-59e4b63c.js";
import M from "./average-task-rate-detail.vue.js";
import { i as c } from "../../../shared/runtime.js";
import "../../../modules/index-18acf776.js";
const H = { __name: "average-task-rate", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, taskWorkshopId: { type: Number }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(i) {
  const l = u(), d = u(false), m = u(false), r = i;
  v(() => r.query, (n) => {
    l.value = r.query.workshopId || void 0, h();
  }, { deep: true }), v(() => r.taskWorkshopId, (n) => {
    l.value = r.query.workshopId || n, h();
  }, { deep: true });
  const { getMyChart: g } = O({ elementId: "averageTaskRateChart", fetchHook: h, initOption: { legend: { show: false }, tooltip: { trigger: "item", show: false }, title: { text: "全年平均任务达成率", textStyle: { fontStyle: "normal", fontWeight: "bold", fontFamily: "sans-serif", fontSize: 12 } }, series: [{ type: "pie", radius: ["40%", "70%"], label: { show: true, position: "center", formatter: "{c}%", fontSize: 16, fontWeight: "bold" }, data: [{ value: 80, label: { normal: { show: true } } }, { value: 20, itemStyle: { color: "#f1f1f1" }, label: { normal: { show: false } } }] }] } });
  async function h(n) {
    try {
      d.value = true;
      const t = n || g(), o = t.getOption(), a = await C({ ...r.query, workshopId: l.value }) || [], f = a == null ? void 0 : a.reduce((s, e) => c(e == null ? void 0 : e.mete) ? s + (e == null ? void 0 : e.mete) : s, 0), p = a == null ? void 0 : a.reduce((s, e) => c(e == null ? void 0 : e.taskMete) ? s + (e == null ? void 0 : e.taskMete) : s, 0);
      o.series[0].data[0].value = f && p ? (f / p * 100).toFixed(2) : 0, o.series[0].data[1].value = 100 - o.series[0].data[0].value, t.setOption(o), t.on("click", function(s) {
        m.value = true;
      });
    } catch (t) {
      console.log(t, "获取差异分析柱状图失败");
    } finally {
      d.value = false;
    }
  }
  return (n, t) => {
    var a;
    const o = S;
    return y(), k(x, null, [b((y(), k("div", { style: w({ height: i.maxHeight + "px" }) }, t[1] || (t[1] = [I("div", { id: "averageTaskRateChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[o, d.value]]), q(M, { visible: m.value, "onUpdate:visible": t[0] || (t[0] = (f) => m.value = f), query: i.query, workshopId: l.value, branchInfo: i.branchInfo, permission: (a = i.permission) == null ? void 0 : a.workshopTask }, null, 8, ["visible", "query", "workshopId", "branchInfo", "permission"])], 64);
  };
} };
export {
  H as default
};
