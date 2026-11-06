import { ref as m } from "vue";
import { watch as O } from "vue";
import { openBlock as y } from "vue";
import { createBlock as q } from "vue";
import { withCtx as _ } from "vue";
import { createElementVNode as d } from "vue";
import { withDirectives as w } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as F } from "vue";
import { ElCard as N } from "element-plus";
import { vLoading as k } from "element-plus";
import { e as B, f as z } from "../../../../modules/program-analysis-f1c6c876.js";
import { u as S } from "../../../../modules/use-chart-59e4b63c.js";
import D from "./project-cost-analysis-detail.vue.js";
import { _ as L } from "../../../../shared/runtime.js";
import "../../../../modules/index-18acf776.js";
const E = { style: { display: "flex" } }, H = { style: { height: "260px", flex: "1" } }, T = { style: { height: "260px", "padding-top": "10px", flex: "2" } }, V = { __name: "project-cost-analysis", props: { maxHeight: [Number, String], default: void 0, query: { type: Object, default: () => {
} }, projectInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(c) {
  const f = m(false), h = m(false), u = m(false), v = m([]), r = c;
  O([() => {
    var s;
    return (s = r.projectInfo) == null ? void 0 : s.id;
  }, () => r.query], (s) => {
    g(), C();
  });
  const { getMyChart: I } = S({ elementId: "projectCostAnalysisChart", fetchHook: g, initOption: { color: ["#009DFF", "#22E4FF", "#3BFFD0", "#04E38A", "#9DFF86"], custom: { title: [{ text: "", textStyle: { fontSize: 16, color: "#000000", fontWeight: "bold" }, textAlign: "center", textVerticalAlign: "middle", left: "50%", top: "50%" }, { text: "单位：元", top: 13, right: 0, textStyle: { fontSize: 13 } }] }, tooltip: { trigger: "item", appendToBody: true, position: function(s, o, a, n, e) {
    var t = 0, i = 0, l = s[0], p = s[1], x = e.contentSize[0], b = e.contentSize[1];
    return x > l ? t = 5 : t = l - x, b > p ? i = 5 : i = p - b, [t, i];
  }, confine: true, extraCssText: "max-width: 370px;white-space:pre-wrap;" }, legend: { show: true, orient: "horizontal", type: "scroll", bottom: 3, left: "center", formatter: function(s) {
    let o = "";
    const a = s.length, n = 15, e = Math.ceil(a / n);
    if (a > n) for (let t = 0; t < e; t++) {
      const i = t * n, l = i + n, p = t === e - 1 ? s.substring(i, a) : s.substring(i, l) + `
`;
      o += p;
    }
    else o = s;
    return o;
  } }, series: [{ type: "pie", radius: ["40%", "60%"], center: ["50%", "50%"], data: [{ name: "合同（结算）额", value: 0 }, { name: "累计成本", value: 0 }], label: { formatter: (s) => `${s.value}` }, emphasis: { itemStyle: { shadowBlur: 10, shadowOffsetX: 0, shadowColor: "rgba(0, 0, 0, 0.5)" } } }] } });
  async function g(s) {
    var o, a, n;
    try {
      f.value = true;
      const e = s || I();
      e.on("click", function(l) {
        u.value = true;
      });
      const t = await B({ projectId: (o = r.projectInfo) == null ? void 0 : o.id, branchCompanyId: (a = r.query) == null ? void 0 : a.branchCompanyId, settlementStatus: (n = r.query) == null ? void 0 : n.settlementStatus }), i = e.getOption();
      i.series[0].data = [{ name: "合同（结算）额", value: (t == null ? void 0 : t.amount) || 0 }, { name: "累计成本", value: (t == null ? void 0 : t.cumulativeCost) || 0 }], i.title[0].text = t != null && t.cmulativeCost && (t != null && t.amount) ? ((t == null ? void 0 : t.cmulativeCost) / (t == null ? void 0 : t.amount) * 100).toFixed(0) + "%" : "0%", e.setOption(i);
    } catch (e) {
      console.log(e, "获取项目分析圆环图失败");
    } finally {
      f.value = false;
    }
  }
  const { getMyChart: A } = S({ elementId: "monthlyConstAnalysisChart", fetchHook: C, initOption: { grid: { top: "30", bottom: "10" }, legend: { show: false }, custom: { title: [{ text: "单位：元", right: 0, textStyle: { fontSize: 13 } }] }, xAxis: { axisTick: { show: false }, data: [] }, yAxis: { axisLabel: { formatter: "{value}" } }, series: [{ name: "投料数据", data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], type: "bar", label: { show: true, distance: 5, position: "top" }, itemStyle: { color: "#009dff" } }] } });
  async function C(s) {
    var o, a;
    try {
      h.value = true;
      const n = s || A(), e = await z({ projectId: (o = r.projectInfo) == null ? void 0 : o.id, branchCompanyId: (a = r.query) == null ? void 0 : a.branchCompanyId }), t = n.getOption();
      n.on("click", function(i) {
        u.value = true;
      }), v.value = e || [], t.xAxis[0].data = e == null ? void 0 : e.map((i) => i.costTypeName), t.series[0].data = e == null ? void 0 : e.map((i) => i.amount), n.setOption(t);
    } catch (n) {
      console.log(n, "获取项目分析柱状图失败");
    } finally {
      h.value = false;
    }
  }
  return (s, o) => {
    const a = N, n = k;
    return y(), q(a, null, { header: _(() => o[1] || (o[1] = [d("div", null, "项目成本分析", -1)])), default: _(() => {
      var e;
      return [d("div", E, [w((y(), j("div", H, o[2] || (o[2] = [d("div", { id: "projectCostAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]))), [[n, f.value]]), w((y(), j("div", T, o[3] || (o[3] = [d("div", { id: "monthlyConstAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]))), [[n, h.value]])]), F(D, { visible: u.value, "onUpdate:visible": o[0] || (o[0] = (t) => u.value = t), "detail-list": v.value, "project-info": c.projectInfo, query: c.query, permission: (e = c.permission) == null ? void 0 : e.cost }, null, 8, ["visible", "detail-list", "project-info", "query", "permission"])];
    }), _: 1 });
  };
} }, Y = L(V, [["__scopeId", "data-v-6def29a0"]]);
export {
  Y as default
};
