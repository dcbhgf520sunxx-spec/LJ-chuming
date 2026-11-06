import { ref as v } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as b } from "vue";
import { normalizeStyle as w } from "vue";
import { createBlock as H } from "vue";
import { withCtx as _ } from "vue";
import { createVNode as r } from "vue";
import { Fragment as B } from "vue";
import { ElTableColumn as T } from "element-plus";
import { vLoading as A } from "element-plus";
import { ba as D } from "../../../shared/runtime.js";
import { u as I } from "../../../modules/use-chart-59e4b63c.js";
import j from "./artifact-type-statistics-detail.vue.js";
import "../../../modules/index-18acf776.js";
import "../../../modules/project-overview-1b3937a7.js";
const q = { style: { display: "flex" } }, V = { __name: "artifact-type-analysis", props: { maxHeight: [Number, String], default: void 0, projectId: { type: Number } }, setup(s) {
  const p = v(false), d = v(false), x = v([{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}]), { getMyChart: C } = I({ elementId: "artifactTypeAnalysisChart", fetchHook: k, initOption: { color: ["#009DFF", "#22E4FF", "#3BFFD0", "#04E38A", "#9DFF86"], tooltip: { trigger: "item", appendToBody: true, position: function(t, e, a, o, n) {
    var l = 0, i = 0, m = t[0], u = t[1], h = n.contentSize[0], g = n.contentSize[1];
    return h > m ? l = 5 : l = m - h, g > u ? i = 5 : i = u - g, [l, i];
  }, confine: true, extraCssText: "max-width: 370px;white-space:pre-wrap;" }, legend: { show: true, orient: "vertical", type: "scroll", top: 7, right: 10, formatter: function(t) {
    let e = "";
    const a = t.length, o = 15, n = Math.ceil(a / o);
    if (a > o) for (let l = 0; l < n; l++) {
      const i = l * o, m = i + o, u = l === n - 1 ? t.substring(i, a) : t.substring(i, m) + `
`;
      e += u;
    }
    else e = t;
    return e;
  } }, series: [{ type: "pie", center: ["35%", "45%"], data: [{ name: "焊接H型构件", value: "10" }, { name: "箱体构件", value: "15" }, { name: "圆管构件", value: "25" }, { name: "方管构件", value: "10" }, { name: "变形构件", value: "30" }, { name: "构件1", value: "10" }, { name: "构件2", value: "15" }, { name: "构件3", value: "25" }, { name: "构件4", value: "10" }, { name: "构件5", value: "30" }, { name: "构件6", value: "10" }, { name: "构件7", value: "15" }, { name: "构件8", value: "25" }, { name: "构件9", value: "10" }, { name: "构件10", value: "30" }, { name: "构件11", value: "30" }, { name: "构件12", value: "30" }, { name: "构件13", value: "30" }, { name: "构件14", value: "30" }], label: { formatter: (t) => `${t.value}` }, emphasis: { itemStyle: { shadowBlur: 10, shadowOffsetX: 0, shadowColor: "rgba(0, 0, 0, 0.5)" } } }] } });
  async function k(t) {
    try {
      p.value = true;
      const e = t || C();
      e.on("click", function(n) {
        console.log(n, "params");
      });
      const { content: a } = await getDiffAverageAnalysis({ range: 10 }), o = e.getOption();
      o.series[0].data = [{ name: "焊接H型构件", value: "30%" }], e.setOption(o);
    } catch (e) {
      console.log(e, "获取差异分析柱状图失败");
    } finally {
      p.value = false;
    }
  }
  function F(t) {
    return D(t, { props: ["quantity", "mete"] });
  }
  function N(t) {
    d.value = true;
  }
  return (t, e) => {
    const a = T, o = S("common-table"), n = A;
    return f(), y(B, null, [e[2] || (e[2] = c("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "构件类型分析", -1)), c("div", q, [b((f(), y("div", { style: w({ height: s.maxHeight + "px", flex: 1 }) }, e[1] || (e[1] = [c("div", { id: "artifactTypeAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[n, p.value]]), c("div", { style: w(`width: 70%;height: ${s.maxHeight}px`) }, [b((f(), H(o, { ref: "tableRef", data: x.value, height: s.maxHeight, "show-summary": "", "summary-method": F, style: { width: "100%", cursor: "pointer" }, onRowClick: N }, { default: _(() => [r(a, { align: "center", label: "序号", type: "index", width: "55" }), r(a, { key: "mainType", align: "center", "show-overflow-tooltip": "", label: "构件类型", prop: "mainType" }), r(a, { key: "quantity", align: "center", "show-overflow-tooltip": "", label: "数量", prop: "quantity" }), r(a, { key: "mete", prop: "mete", align: "center", "show-overflow-tooltip": "", label: "重量（吨）" }), r(a, { key: "productMete", prop: "productMete", align: "center", "show-overflow-tooltip": "", label: "占比" })]), _: 1 }, 8, ["data", "height"])), [[n, t.tableLoading]]), r(j, { visible: d.value, "onUpdate:visible": e[0] || (e[0] = (l) => d.value = l), projectId: s.projectId }, null, 8, ["visible", "projectId"])], 4)])], 64);
  };
} };
export {
  V as default
};
