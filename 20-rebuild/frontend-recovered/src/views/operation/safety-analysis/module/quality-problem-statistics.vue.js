import { ref as d } from "vue";
import { openBlock as p } from "vue";
import { createBlock as x } from "vue";
import { withCtx as f } from "vue";
import { createElementVNode as g } from "vue";
import { withDirectives as w } from "vue";
import { createElementBlock as C } from "vue";
import { normalizeStyle as S } from "vue";
import { createVNode as _ } from "vue";
import { ElCard as F } from "element-plus";
import { vLoading as N } from "element-plus";
import { u as B } from "../../../../modules/use-chart-59e4b63c.js";
import A from "./safety-problem-statistics-detail.vue.js";
import "../../../../modules/index-18acf776.js";
import "../../../../shared/runtime.js";
import "../../../../modules/project-overview-1b3937a7.js";
const z = { __name: "quality-problem-statistics", props: { permission: { type: Object, default: () => {
} }, query: { type: Object, default: () => {
} }, maxHeight: { type: [Number, String], default: void 0 } }, setup(h) {
  const u = d(false), m = d(false), { getMyChart: y } = B({ elementId: "qualityProblemAnalysis", fetchHook: b, initOption: { color: ["#009DFF", "#22E4FF", "#3BFFD0", "#04E38A", "#9DFF86"], title: { subtext: "250起", subtextStyle: { fontSize: 18, color: "#000000", fontWeight: "bold" }, textAlign: "center", x: "34%", y: "43%" }, tooltip: { trigger: "item", appendToBody: true, position: function(t, e, o, a, n) {
    var l = 0, r = 0, i = t[0], s = t[1], c = n.contentSize[0], v = n.contentSize[1];
    return c > i ? l = 5 : l = i - c, v > s ? r = 5 : r = s - v, [l, r];
  }, confine: true, extraCssText: "max-width: 370px;white-space:pre-wrap;" }, legend: { show: true, orient: "vertical", type: "scroll", top: 7, right: 10, formatter: function(t) {
    let e = "";
    const o = t.length, a = 15, n = Math.ceil(o / a);
    if (o > a) for (let l = 0; l < n; l++) {
      const r = l * a, i = r + a, s = l === n - 1 ? t.substring(r, o) : t.substring(r, i) + `
`;
      e += s;
    }
    else e = t;
    return e;
  } }, series: [{ type: "pie", radius: ["40%", "60%"], center: ["35%", "50%"], data: [{ name: "焊接H型构件", value: "10" }, { name: "箱体构件", value: "15" }, { name: "圆管构件", value: "25" }, { name: "方管构件", value: "10" }, { name: "变形构件", value: "30" }, { name: "构件1", value: "10" }, { name: "构件2", value: "15" }, { name: "构件3", value: "25" }, { name: "构件4", value: "10" }, { name: "构件5", value: "30" }, { name: "构件6", value: "10" }, { name: "构件7", value: "15" }, { name: "构件8", value: "25" }, { name: "构件9", value: "10" }, { name: "构件10", value: "30" }, { name: "构件11", value: "30" }, { name: "构件12", value: "30" }, { name: "构件13", value: "30" }, { name: "构件14", value: "30" }], label: { formatter: (t) => `${t.value}` }, emphasis: { itemStyle: { shadowBlur: 10, shadowOffsetX: 0, shadowColor: "rgba(0, 0, 0, 0.5)" } } }] } });
  async function b(t) {
    try {
      u.value = true;
      const e = t || y();
      e.on("click", function(n) {
        console.log(n, "params"), m.value = true;
      });
      const { content: o } = await getDiffAverageAnalysis({ range: 10 }), a = e.getOption();
      a.series[0].data = [{ name: "焊接H型构件", value: "30%" }], e.setOption(a);
    } catch (e) {
      console.log(e, "获取差异分析柱状图失败");
    } finally {
      u.value = false;
    }
  }
  return (t, e) => {
    const o = F, a = N;
    return p(), x(o, null, { header: f(() => e[1] || (e[1] = [g("div", null, "质量问题(一级)统计", -1)])), default: f(() => [w((p(), C("div", { style: S({ height: h.maxHeight + "px" }) }, e[2] || (e[2] = [g("div", { id: "qualityProblemAnalysis", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[a, u.value]]), _(A, { visible: m.value, "onUpdate:visible": e[0] || (e[0] = (n) => m.value = n) }, null, 8, ["visible"])]), _: 1 });
  };
} };
export {
  z as default
};
