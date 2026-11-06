import { ref as v } from "vue";
import { watch as C } from "vue";
import { openBlock as b } from "vue";
import { createBlock as I } from "vue";
import { withCtx as _ } from "vue";
import { createElementVNode as j } from "vue";
import { withDirectives as S } from "vue";
import { createElementBlock as F } from "vue";
import { createVNode as W } from "vue";
import { ElCard as k } from "element-plus";
import { vLoading as q } from "element-plus";
import { b as E } from "../../../../modules/program-analysis-f1c6c876.js";
import { u as B } from "../../../../modules/use-chart-v2-ba3ec3fa.js";
import O from "./project-execution-status-detail.vue.js";
import { _ as L } from "../../../../shared/runtime.js";
import "../../../../modules/index-18acf776.js";
const N = { style: { height: "240px", "padding-top": "10px" } }, V = { __name: "project-execution-status", props: { maxHeight: [Number, String], default: void 0, query: { type: Object, default: () => {
} }, projectInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(r) {
  const c = v(false), u = v(false), s = r;
  C([() => s.query, () => {
    var e;
    return (e = s.projectInfo) == null ? void 0 : e.id;
  }], (e) => {
    f();
  });
  const { getMyChart: w } = B({ elementId: "projectExecutionStatusChart", fetchHook: f, initOption: { grid: { top: "35", right: "30", bottom: "15" }, legend: { data: ["清单（合同）量", "完成量"], left: "center" }, yAxis: [{ data: ["深化设计", "生产加工", "物流发运", "项目安装"], axisLabel: { rotate: 45 } }], xAxis: { axisLabel: { formatter: "{value}" } }, series: [{ name: "清单（合同）量", type: "bar", stack: "total", emphasis: { itemStyle: { shadowBlur: 10, shadowColor: "rgba(0,0,0,0.3)" } }, label: { show: true, distance: 5, position: "inside", formatter: (e) => {
    if (e.value > 0) return e.value + " 吨";
  } }, data: [10, 20] }, { name: "完成量", type: "bar", stack: "total", emphasis: { itemStyle: { shadowBlur: 10, shadowColor: "rgba(0,0,0,0.3)" } }, label: { show: true, distance: 5, position: "right", formatter: (e) => {
    if (e.value > 0) return e.value + " 吨";
  } }, data: [20, 30] }] } });
  async function f(e) {
    var t, n, l, o, d, h, m, g, x, y;
    try {
      c.value = true;
      const i = e || w(), a = await E({ projectId: (t = s.projectInfo) == null ? void 0 : t.id, branchCompanyId: (n = s.query) == null ? void 0 : n.branchCompanyId }), p = i.getOption();
      i.on("click", function(A) {
        u.value = true;
      }), p.series[0].data = [(l = a.contractWeight) == null ? void 0 : l.toFixed(0), (o = a.deepenWeight) == null ? void 0 : o.toFixed(0), (d = a.deepenWeight) == null ? void 0 : d.toFixed(0), (h = a.deepenWeight) == null ? void 0 : h.toFixed(0)], p.series[1].data = [(m = a.deepenWeight) == null ? void 0 : m.toFixed(0), (g = a.producedWeight) == null ? void 0 : g.toFixed(0), (x = a.deliveryWeight) == null ? void 0 : x.toFixed(0), (y = a.installWeight) == null ? void 0 : y.toFixed(0)], i.setOption(p);
    } catch (i) {
      console.log(i, "获取差异分析柱状图失败");
    } finally {
      c.value = false;
    }
  }
  return (e, t) => {
    const n = k, l = q;
    return b(), I(n, null, { header: _(() => t[1] || (t[1] = [j("div", null, "项目执行状态", -1)])), default: _(() => {
      var o;
      return [S((b(), F("div", N, t[2] || (t[2] = [j("div", { id: "projectExecutionStatusChart", style: { width: "100%", height: "100%" } }, null, -1)]))), [[l, c.value]]), W(O, { visible: u.value, "onUpdate:visible": t[0] || (t[0] = (d) => u.value = d), projectInfo: r.projectInfo, query: r.query, permission: (o = r.permission) == null ? void 0 : o.execution }, null, 8, ["visible", "projectInfo", "query", "permission"])];
    }), _: 1 });
  };
} }, G = L(V, [["__scopeId", "data-v-809a0ee8"]]);
export {
  G as default
};
