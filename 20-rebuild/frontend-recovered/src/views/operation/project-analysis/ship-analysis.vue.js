import { ref as h } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as u } from "vue";
import { withDirectives as w } from "vue";
import { normalizeStyle as b } from "vue";
import { createBlock as S } from "vue";
import { withCtx as H } from "vue";
import { createVNode as r } from "vue";
import { Fragment as N } from "vue";
import { ElTableColumn as B } from "element-plus";
import { vLoading as A } from "element-plus";
import { ba as D } from "../../../shared/runtime.js";
import { u as q } from "../../../modules/use-chart-59e4b63c.js";
import E from "./ship-statistics-detail.vue.js";
import "../../../modules/index-18acf776.js";
import "../../../modules/project-overview-1b3937a7.js";
const O = { style: { display: "flex" } }, X = { __name: "ship-analysis", props: { maxHeight: [Number, String], default: void 0 }, setup(c) {
  const p = h(false), v = h(false), x = h([{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}]), { getMyChart: C } = q({ elementId: "shipAnalysisChart", fetchHook: k, initOption: { color: ["#009DFF", "#22E4FF", "#3BFFD0", "#04E38A", "#9DFF86"], tooltip: { trigger: "item", appendToBody: true, position: function(t, e, a, o, n) {
    var l = 0, i = 0, s = t[0], m = t[1], f = n.contentSize[0], g = n.contentSize[1];
    return f > s ? l = 5 : l = s - f, g > m ? i = 5 : i = m - g, [l, i];
  }, confine: true, extraCssText: "max-width: 370px;white-space:pre-wrap;" }, legend: { show: true, orient: "vertical", type: "scroll", top: 7, right: 10, formatter: function(t) {
    let e = "";
    const a = t.length, o = 15, n = Math.ceil(a / o);
    if (a > o) for (let l = 0; l < n; l++) {
      const i = l * o, s = i + o, m = l === n - 1 ? t.substring(i, a) : t.substring(i, s) + `
`;
      e += m;
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
  function _(t) {
    return D(t, { props: ["quantity", "totalMete", "aveMete"] });
  }
  function F(t) {
    v.value = true;
  }
  return (t, e) => {
    const a = B, o = M("common-table"), n = A;
    return d(), y(N, null, [e[2] || (e[2] = u("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "发运分析", -1)), u("div", O, [w((d(), y("div", { style: b({ height: c.maxHeight + "px", flex: 1 }) }, e[1] || (e[1] = [u("div", { id: "shipAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[n, p.value]]), u("div", { style: b(`width: 70%;height: ${c.maxHeight}px`) }, [w((d(), S(o, { ref: "tableRef", data: x.value, height: c.maxHeight, "show-summary": "", "summary-method": _, style: { width: "100%", cursor: "pointer" }, onRowClick: F }, { default: H(() => [r(a, { align: "center", label: "序号", type: "index", width: "55" }), r(a, { key: "carModel", align: "center", "show-overflow-tooltip": "", label: "车型", prop: "mainType" }), r(a, { key: "quantity", align: "center", "show-overflow-tooltip": "", label: "车次/船次", prop: "quantity" }), r(a, { key: "unit", align: "center", "show-overflow-tooltip": "", label: "单位", prop: "unit" }), r(a, { key: "totalMete", prop: "totalMete", align: "center", "show-overflow-tooltip": "", label: "累计装载重量（过磅）" }), r(a, { key: "aveMete", prop: "aveMete", align: "center", "show-overflow-tooltip": "", label: "平均装载重量（过磅）" })]), _: 1 }, 8, ["data", "height"])), [[n, t.tableLoading]]), r(E, { visible: v.value, "onUpdate:visible": e[0] || (e[0] = (l) => v.value = l) }, null, 8, ["visible"])], 4)])], 64);
  };
} };
export {
  X as default
};
