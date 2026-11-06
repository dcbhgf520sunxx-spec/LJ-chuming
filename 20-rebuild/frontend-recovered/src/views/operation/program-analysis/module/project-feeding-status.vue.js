import { ref as u } from "vue";
import { watch as v } from "vue";
import { openBlock as f } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as m } from "vue";
import { createElementVNode as y } from "vue";
import { withDirectives as x } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as j } from "vue";
import { ElCard as S } from "element-plus";
import { vLoading as w } from "element-plus";
import { d as C } from "../../../../modules/program-analysis-f1c6c876.js";
import { _ as I, c as g } from "../../../../shared/runtime.js";
import { u as k } from "../../../../modules/use-chart-59e4b63c.js";
import q from "./project-feeding-status-detail.vue.js";
import "../../../../modules/index-18acf776.js";
const O = { style: { height: "300px", "padding-top": "10px" } }, F = { __name: "project-feeding-status", props: { query: { type: Object, default: () => ({}) }, projectInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(r) {
  const n = r, c = u(false), p = u(false);
  v([() => n.query, () => {
    var a;
    return (a = n.projectInfo) == null ? void 0 : a.id;
  }], (a) => {
    d();
  });
  const { getMyChart: h } = k({ elementId: "projectFeedingStatusChart", fetchHook: d, initOption: { grid: { top: "40", bottom: "10" }, legend: { show: true }, custom: { title: [{ text: "单位：吨", right: 0, textStyle: { fontSize: 13 } }] }, tooltip: { show: true }, xAxis: { type: "category", axisTick: { show: true }, data: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"] }, yAxis: { axisLabel: { formatter: "{value}" } }, title: { text: "" }, series: [{ name: "投料数据", data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], type: "line", areaStyle: {}, label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#00b2ff" } }, { name: "生产数据", data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], type: "line", areaStyle: {}, label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#65edff" } }] } });
  async function d(a) {
    var t, l;
    try {
      c.value = true;
      const o = a || h();
      o.on("click", function(s) {
        p.value = true;
      });
      const e = await C({ projectId: (t = n.projectInfo) == null ? void 0 : t.id, branchCompanyId: (l = n.query) == null ? void 0 : l.branchCompanyId, isRecently: true }), i = o.getOption();
      i.xAxis[0].data = e == null ? void 0 : e.map((s) => s.dateTime), i.series[0].data = e == null ? void 0 : e.map((s) => g(s.feedingMete, "kg", "t", 0)), i.series[1].data = e == null ? void 0 : e.map((s) => g(s.produceMete, "kg", "t", 0)), o.setOption(i);
    } catch (o) {
      console.log(o, "获取项目投料状态失败");
    } finally {
      c.value = false;
    }
  }
  return (a, t) => {
    const l = S, o = w;
    return f(), _(l, null, { header: m(() => t[1] || (t[1] = [y("div", null, "项目投料状态", -1)])), default: m(() => {
      var e;
      return [x((f(), b("div", O, t[2] || (t[2] = [y("div", { id: "projectFeedingStatusChart", style: { width: "100%", height: "100%" } }, null, -1)]))), [[o, c.value]]), j(q, { visible: p.value, "onUpdate:visible": t[0] || (t[0] = (i) => p.value = i), query: r.query, projectInfo: r.projectInfo, permission: (e = r.permission) == null ? void 0 : e.execution }, null, 8, ["visible", "query", "projectInfo", "permission"])];
    }), _: 1 });
  };
} }, N = I(F, [["__scopeId", "data-v-28a73b2f"]]);
export {
  N as default
};
