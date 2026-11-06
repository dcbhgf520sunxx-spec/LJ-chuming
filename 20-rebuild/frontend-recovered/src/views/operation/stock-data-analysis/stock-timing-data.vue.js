import { ref as f } from "vue";
import { watch as z } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as k } from "vue";
import { normalizeStyle as C } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as y } from "vue";
import { withCtx as g } from "vue";
import { createTextVNode as A } from "vue";
import { toDisplayString as D } from "vue";
import { unref as H } from "vue";
import { createBlock as B } from "vue";
import { createCommentVNode as $ } from "vue";
import { ElDivider as M } from "element-plus";
import { ElTag as P } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { vLoading as G } from "element-plus";
import { b as R, c as W, e as Y } from "../../../modules/stock-data-analysis-37c7a329.js";
import { G as E, L as J } from "../../../shared/runtime.js";
import { u as K } from "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
const Q = { style: { display: "flex" } }, U = { style: { "margin-bottom": "10px", display: "flex", "justify-content": "space-between" } }, ne = { __name: "stock-timing-data", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(d) {
  const v = f(false), _ = f(), b = f({}), x = f([]), S = f(false), c = d;
  z(() => c.query, (o) => {
    F(), x.value = [], b.value.name = void 0;
  }, { deep: true });
  const { getMyChart: O } = K({ elementId: "steelStockChart", fetchHook: F, initOption: { custom: { title: [{ text: "仓库实时库存金额统计" }, { text: "单位：万元", right: 0, textStyle: { fontSize: 13 } }] }, color: ["#009DFF", "#22E4FF", "#3BFFD0", "#04E38A", "#9DFF86"], tooltip: { trigger: "item", appendToBody: true, position: function(o, n, s, e, a) {
    var t = 0, i = 0, r = o[0], l = o[1], u = a.contentSize[0], p = a.contentSize[1];
    return u > r ? t = 5 : t = r - u, p > l ? i = 5 : i = l - p, [t, i];
  }, confine: true, extraCssText: "max-width: 370px;white-space:pre-wrap;" }, legend: { show: true, orient: "vertical", type: "scroll", top: "center", right: 10, formatter: function(o) {
    let n = "";
    const s = o.length, e = 7, a = Math.ceil(s / e);
    if (s > e) for (let t = 0; t < a; t++) {
      const i = t * e, r = i + e, l = t === a - 1 ? o.substring(i, s) : o.substring(i, r) + `
`;
      n += l;
    }
    else n = o;
    return n;
  } }, series: [{ type: "pie", center: ["35%", "55%"], data: [], label: { formatter: (o) => `${o.value}` }, emphasis: { itemStyle: { shadowBlur: 10, shadowOffsetX: 0, shadowColor: "rgba(0, 0, 0, 0.5)" } } }] } });
  async function F(o) {
    var n;
    if (!E((n = c.permission) == null ? void 0 : n.get)) return false;
    try {
      v.value = true;
      const s = o || O(), e = await R({ ...c.query }), a = s.getOption();
      a.series[0].data = e == null ? void 0 : e.map((t) => ({ name: t.className, value: t.amountExcludingVAT ? (t.amountExcludingVAT / 1e4).toFixed(0) : 0 })), s.setOption(a), s.on("click", async (t) => {
        var i;
        b.value = t || {}, _.value = (i = e == null ? void 0 : e.find((r) => r.className === t.name)) == null ? void 0 : i.basicClass, await j();
      });
    } catch (s) {
      console.log(s, "获取实时库存图表失败");
    } finally {
      v.value = false;
    }
  }
  async function j() {
    var o, n, s, e;
    if (!E((n = (o = c.permission) == null ? void 0 : o.amount) == null ? void 0 : n.detail)) return false;
    try {
      S.value = true;
      const a = await W({ monthDate: (s = c.query) == null ? void 0 : s.yearDate, basicClass: _.value, branchCompanyId: (e = c.query) == null ? void 0 : e.branchCompanyId });
      x.value = a || [];
    } catch (a) {
      console.log(a, "获取库存详情失败");
    } finally {
      S.value = false;
    }
  }
  function I(o) {
    const { columns: n, data: s } = o, e = [];
    return n.forEach((a, t) => {
      if (t === 0) {
        e[t] = "合计";
        return;
      }
      if (a.property === "amountExcludingVAT") {
        const i = s.map((l) => Number(l[a.property]));
        let r = 0;
        i.every((l) => isNaN(l)) || (r = i.reduce((l, u) => {
          const p = Number(u);
          return isNaN(p) ? l : l + u;
        }, 0)), e[t] = (r / 1e4).toFixed(0);
      }
    }), e;
  }
  return (o, n) => {
    var r, l, u, p, T, V;
    const s = M, e = P, a = X, t = L("common-table"), i = G;
    return h(), w("div", Q, [k((h(), w("div", { style: C({ height: d.maxHeight + "px", width: "30%" }) }, n[0] || (n[0] = [N("div", { id: "steelStockChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[i, v.value]]), y(s, { direction: "vertical", style: C(`height: ${d.maxHeight}px`) }, null, 8, ["style"]), (r = b.value) != null && r.name ? k((h(), w("div", { key: 1, style: C({ height: d.maxHeight + "px", width: "70%" }) }, [N("div", U, [y(e, { type: "primary", size: "default", effect: "plain" }, { default: g(() => {
      var m;
      return [A(D(((m = b.value) == null ? void 0 : m.name) || "-"), 1)];
    }), _: 1 }), H(E)((u = (l = d.permission) == null ? void 0 : l.amount) == null ? void 0 : u.download) ? (h(), B(J, { key: 0, fn: H(Y), params: { monthDate: (p = c.query) == null ? void 0 : p.yearDate, basicClass: _.value, branchCompanyId: (T = c.query) == null ? void 0 : T.branchCompanyId }, disabled: !((V = x.value) != null && V.length) }, { default: g(() => n[1] || (n[1] = [A(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : $("", true)]), k((h(), B(t, { ref: "tableRef", data: x.value, "max-height": d.maxHeight - 40, style: { width: "100%" }, "show-summary": "", "summary-method": I }, { default: g(() => [y(a, { "show-overflow-tooltip": true, prop: "className", label: "类型", align: "center" }), y(a, { "show-overflow-tooltip": true, prop: "amountExcludingVAT", label: "库存金额（万元）", align: "center" }, { default: g(({ row: m }) => [N("span", null, D(m.amountExcludingVAT ? (m.amountExcludingVAT / 1e4).toFixed(0) : 0), 1)]), _: 1 }), y(a, { "show-overflow-tooltip": true, prop: "ratio", label: "占比", align: "center" }, { default: g(({ row: m }) => {
      var q;
      return [N("span", null, D(m.ratio ? (q = m.ratio) == null ? void 0 : q.toFixed(2) : 0) + "%", 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[i, S.value]])], 4)), [[i, v.value]]) : (h(), w("div", { key: 0, style: C({ height: d.maxHeight + "px", width: "70%" }), class: "red-tip" }, "* 点击左侧图表展示详情", 4))]);
  };
} };
export {
  ne as default
};
