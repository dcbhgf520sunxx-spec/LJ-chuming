import { ref as N } from "vue";
import { watch as S } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as x } from "vue";
import { createBlock as V } from "vue";
import { withCtx as i } from "vue";
import { createVNode as m } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as g } from "vue";
import { unref as d } from "vue";
import { createCommentVNode as U } from "vue";
import { createElementVNode as T } from "vue";
import { isRef as q } from "vue";
import { ElTag as D } from "element-plus";
import { ElTableColumn as P } from "element-plus";
import { j as z, o as F } from "../../../modules/stock-data-analysis-37c7a329.js";
import { hW as O, u as G, G as E, o as L, L as M, c as B } from "../../../shared/runtime.js";
const K = { __name: "remain-stock-analysis-detail", props: { visible: { type: Boolean, default: false }, query: { type: Object, default: () => {
} }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(p, { emit: R }) {
  const { workshopName: A } = O(), h = N([]), v = N(""), C = R, c = p, { visible: b, handleClose: j } = G({ emit: C, props: c, field: "visible", showHook: _ });
  S(() => c.visible, (u) => {
    var s, l;
    u && (v.value = (l = (s = A.value) == null ? void 0 : s.find((e) => {
      var n;
      return e.id === ((n = c.query) == null ? void 0 : n.workshopId);
    })) == null ? void 0 : l.name, _());
  }, { immediate: true });
  async function _() {
    var s;
    if (!E((s = c.permission) == null ? void 0 : s.detail)) return false;
    let u = [];
    try {
      u = await z({ ...c.query }) || [];
    } catch (l) {
      console.log("获取余料库存详情失败", l);
    } finally {
      h.value = u;
    }
  }
  const { maxHeight: H } = L({ mainBox: ".remain-stock-class", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, paginate: true, navbar: false }, b);
  function I(u) {
    const { columns: s, data: l } = u, e = [];
    return s.forEach((n, r) => {
      var t;
      if (r === 0) {
        e[r] = "合计";
        return;
      }
      if (n.property === "amountExcludingVAT") {
        const a = l.map((o) => Number(o[n.property]));
        a.every((o) => isNaN(o)) || (e[r] = a.reduce((o, f) => {
          const w = Number(f);
          return isNaN(w) ? o : o + f;
        }, 0)), e[r] = (t = e[r]) == null ? void 0 : t.toFixed(2);
      }
      if (n.property === "mete") {
        const a = l.map((o) => Number(o[n.property]));
        a.every((o) => isNaN(o)) || (e[r] = a.reduce((o, f) => {
          const w = Number(f);
          return isNaN(w) ? o : o + f;
        }, 0)), e[r] = B(e[r], "g", "t", 0);
      }
    }), e;
  }
  return (u, s) => {
    const l = D, e = P, n = k("common-table"), r = k("common-drawer");
    return x(), V(r, { ref: "drawerRef", title: "余料库存详情", "custom-class": "remain-stock-class", modelValue: d(b), "onUpdate:modelValue": s[0] || (s[0] = (t) => q(b) ? b.value = t : null), direction: "rtl", "before-close": d(j), size: "60%" }, { titleAfter: i(() => [m(l, { type: "danger", size: "default" }, { default: i(() => {
      var t, a;
      return [y(" 二级单位： " + g((t = p.branchInfo) != null && t.name ? (a = p.branchInfo) == null ? void 0 : a.name : "全部分支机构"), 1)];
    }), _: 1 }), m(l, { size: "default" }, { default: i(() => [y(" 车间： " + g(v.value ? v.value : "全部车间"), 1)]), _: 1 })]), titleRight: i(() => {
      var t, a;
      return [d(E)((t = p.permission) == null ? void 0 : t.download) ? (x(), V(M, { key: 0, fn: d(F), params: { ...c.query }, disabled: !((a = h.value) != null && a.length) }, { default: i(() => s[1] || (s[1] = [y(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : U("", true)];
    }), content: i(() => [m(n, { ref: "tableRef", data: h.value, "max-height": d(H), style: { width: "100%" }, "show-summary": "", "summary-method": I }, { default: i(() => [m(e, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), m(e, { "show-overflow-tooltip": true, prop: "dateTime", label: "日期", align: "center" }), m(e, { "show-overflow-tooltip": true, prop: "mete", label: "余料库存（吨）", align: "center" }, { default: i(({ row: t }) => [T("span", null, g(t.mete ? d(B)(t.mete, "g", "t", 0) : 0), 1)]), _: 1 }), m(e, { "show-overflow-tooltip": true, prop: "amountExcludingVAT", label: "暂估金额（元）", align: "center" }), m(e, { "show-overflow-tooltip": true, prop: "avgUnitPriceExcludingVAT", label: "平均单价（元/吨）", align: "center" }, { default: i(({ row: t }) => {
      var a;
      return [T("span", null, g(t.avgUnitPriceExcludingVAT ? (a = t.avgUnitPriceExcludingVAT) == null ? void 0 : a.toFixed(0) : "-"), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  K as default
};
