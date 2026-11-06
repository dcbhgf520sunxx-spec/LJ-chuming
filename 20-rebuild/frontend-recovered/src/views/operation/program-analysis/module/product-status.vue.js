import { ref as n } from "vue";
import { watch as g } from "vue";
import { openBlock as m } from "vue";
import { createBlock as x } from "vue";
import { withCtx as h } from "vue";
import { createElementVNode as v } from "vue";
import { withDirectives as j } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as C } from "vue";
import { ElCard as I } from "element-plus";
import { vLoading as O } from "element-plus";
import { a as k } from "../../../../modules/program-analysis-f1c6c876.js";
import { u as q } from "../../../../modules/use-chart-v2-ba3ec3fa.js";
import D from "./product-status-detail.vue.js";
import "../../../../shared/runtime.js";
import "../../../../modules/index-18acf776.js";
const M = { style: { height: "200px", "padding-top": "10px" } }, A = { __name: "product-status", props: { query: { type: Object, default: () => ({}) }, projectInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(i) {
  const c = n(false), u = n(false), d = n({}), p = n({}), s = i;
  g([() => s.query, () => {
    var t;
    return (t = s.projectInfo) == null ? void 0 : t.id;
  }], (t) => {
    f();
  });
  const { getMyChart: b } = q({ elementId: "productStatusChart", fetchHook: f, initOption: { grid: { top: "30", right: "30", bottom: "15" }, legend: { data: ["清单量", "完成量"], left: "center" }, yAxis: [{ data: ["零件生产", "部件生产", "构件生产"], axisLabel: { rotate: 45 } }], xAxis: { axisLabel: { formatter: "{value}" } }, series: [{ name: "清单量", type: "bar", stack: "total", emphasis: { itemStyle: { shadowBlur: 10, shadowColor: "rgba(0,0,0,0.3)" } }, label: { show: true, distance: 5, position: "inside", formatter: (t) => {
    if (t.value > 0) return t.value + " 吨";
  } }, data: [0, 0, 0] }, { name: "完成量", type: "bar", stack: "total", emphasis: { itemStyle: { shadowBlur: 10, shadowColor: "rgba(0,0,0,0.3)" } }, label: { show: true, distance: 5, position: "right", formatter: (t) => {
    if (t.value > 0) return t.value + " 吨";
  } }, data: [0, 0, 0] }] } });
  async function f(t) {
    var a, l;
    try {
      c.value = true;
      const o = t || b(), e = await k({ projectId: (a = s.projectInfo) == null ? void 0 : a.id, branchCompanyId: (l = s.query) == null ? void 0 : l.branchCompanyId }), r = o.getOption();
      o.on("click", function(y) {
        d.value = y, u.value = true;
      }), p.value = e || {}, r.series[0].data = [((e == null ? void 0 : e.partDeepMete) / 1e3).toFixed(0), ((e == null ? void 0 : e.assembleDeepMete) / 1e3).toFixed(0), ((e == null ? void 0 : e.artifactDeepMete) / 1e3).toFixed(0)], r.series[1].data = [((e == null ? void 0 : e.partMete) / 1e3).toFixed(0), ((e == null ? void 0 : e.assembleMete) / 1e3).toFixed(0), ((e == null ? void 0 : e.artifactMete) / 1e3).toFixed(0)], o.setOption(r);
    } catch (o) {
      console.log(o, "获取生产状态图表失败");
    } finally {
      c.value = false;
    }
  }
  return (t, a) => {
    const l = I, o = O;
    return m(), x(l, null, { header: h(() => a[1] || (a[1] = [v("div", null, "生产状态", -1)])), default: h(() => {
      var e;
      return [j((m(), w("div", M, a[2] || (a[2] = [v("div", { id: "productStatusChart", style: { width: "100%", height: "100%" } }, null, -1)]))), [[o, c.value]]), C(D, { visible: u.value, "onUpdate:visible": a[0] || (a[0] = (r) => u.value = r), chartObj: d.value, projectInfo: i.projectInfo, detailData: p.value, query: i.query, permission: (e = i.permission) == null ? void 0 : e.product }, null, 8, ["visible", "chartObj", "projectInfo", "detailData", "query", "permission"])];
    }), _: 1 });
  };
} };
export {
  A as default
};
