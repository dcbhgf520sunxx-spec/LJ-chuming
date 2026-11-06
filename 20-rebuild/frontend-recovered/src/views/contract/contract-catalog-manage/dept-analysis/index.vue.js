import { ref as w } from "vue";
import { computed as N } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as y } from "vue";
import { unref as a } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as s } from "vue";
import { withCtx as I } from "vue";
import { Fragment as _ } from "vue";
import { createCommentVNode as r } from "vue";
import { ElTableColumn as M } from "element-plus";
import { vLoading as O } from "element-plus";
import { c as P, m as q } from "./module/header.vue.js";
import { d as B } from "../../../../modules/contract-9b18cc88.js";
import { _ as H, x as F, o as T, i9 as h, i as U, bV as Y } from "../../../../shared/runtime.js";
const j = { class: "app-container" }, K = { __name: "index", setup(z) {
  const b = { add: false, edit: false, del: false, download: false }, g = w(), v = w(), x = N(() => [["totalAmount", ["to-thousand-text"]], ["unSignAmount", ["to-thousand-text"]], ["targetAmount", ["to-thousand-text"]], ["signAmount", ["to-thousand-text"]], ["completeRate", ["suffix", " %"]]]), { crud: c, columns: l, CRUD: S } = F({ title: "部门承接分析表", sort: [], permission: { ...B }, crudApi: P, dataPath: "", invisibleColumns: [], optShow: { ...b }, hasPagination: false }, g), { maxHeight: k } = T({});
  S.HOOK.handleRefresh = (i, u) => {
    if (i.query.type === h.COMPANY.V) {
      const e = [], o = { firstLevelDeptValue: "", id: "sellerSummary", totalAmount: 0, signAmount: 0, unSignAmount: 0, targetAmount: 0, showIndex: "销售部合计" };
      u.data.forEach((t) => {
        t.firstLevelDeptValue === "销售部" && (t.showIndex = e.length + 1, e.push(t), o.totalAmount += t.totalAmount || 0, o.signAmount += t.signAmount || 0, o.unSignAmount += t.unSignAmount || 0, o.targetAmount += t.targetAmount || 0);
      }), U(e) && (o.showIndex = "销售部合计", e.push(o)), u.data.forEach((t) => {
        t.firstLevelDeptValue !== "销售部" && (t.showIndex = e.length + 1, e.push(t));
      }), u.data = e;
    }
  };
  function D({ row: i, column: u, rowIndex: e, columnIndex: o }) {
    if (i.id === "sellerSummary") {
      if (o === 0) return { rowspan: 1, colspan: 3 };
      if (o === 1) return { rowspan: 1, colspan: 0 };
      if (o === 2) return { rowspan: 1, colspan: 0 };
    }
  }
  function V(i) {
    const { columns: u, data: e } = i, o = [];
    return u.forEach((t, d) => {
      if (d === 0) {
        o[d] = "合计";
        return;
      }
      if (t.property === "totalAmount" || t.property === "signAmount" || t.property === "unSignAmount" || t.property === "targetAmount") {
        const R = e.filter((m) => m.id !== "sellerSummary").map((m) => {
          var p;
          return Number((p = m.sourceRow) == null ? void 0 : p[t.property]);
        });
        let A = 0;
        A = R.reduce((m, p) => {
          const L = Number(p);
          return isNaN(L) ? m : m + p;
        }, 0), o[d] = Y(A, 4);
      }
    }), o;
  }
  return (i, u) => {
    const e = M, o = C("common-table"), t = O;
    return n(), f("div", j, [y(a(q), { ref_key: "headerRef", ref: v }, null, 512), E((n(), s(o, { ref_key: "tableRef", ref: g, "data-format": x.value, data: a(c).data, "show-summary": "", "span-method": D, "summary-method": V, style: { width: "100%" }, "max-height": a(k) }, { default: I(() => [a(c).query.type === a(h).SELLER.V ? (n(), f(_, { key: 0 }, [y(e, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), a(l).visible("signerName") ? (n(), s(e, { key: "signerName", prop: "signerName", "show-overflow-tooltip": true, label: "姓名", align: "center" })) : r("", true)], 64)) : (n(), s(e, { label: "序号", key: "showIndex", prop: "showIndex", align: "center", width: "60", fixed: "left" })), a(l).visible("firstLevelDeptValue") ? (n(), s(e, { key: "firstLevelDeptValue", prop: "firstLevelDeptValue", "show-overflow-tooltip": true, label: "所属一级部门名称", align: "center" })) : r("", true), a(l).visible("secondLevelDeptValue") ? (n(), s(e, { key: "secondLevelDeptValue", prop: "secondLevelDeptValue", "show-overflow-tooltip": true, label: "所属二级部门名称", align: "center" })) : r("", true), a(l).visible("totalAmount") ? (n(), s(e, { key: "totalAmount", prop: "totalAmount", "show-overflow-tooltip": true, label: "总合同额", align: "right" })) : r("", true), a(l).visible("signAmount") ? (n(), s(e, { key: "signAmount", prop: "signAmount", "show-overflow-tooltip": true, label: "其中：已签订", align: "right" })) : r("", true), a(l).visible("unSignAmount") ? (n(), s(e, { key: "unSignAmount", prop: "unSignAmount", "show-overflow-tooltip": true, label: "其中：中标未签", align: "right" })) : r("", true), a(c).query.type === a(h).COMPANY.V ? (n(), f(_, { key: 7 }, [a(l).visible("targetAmount") ? (n(), s(e, { key: "targetAmount", prop: "targetAmount", "show-overflow-tooltip": true, label: "目标任务", align: "right" })) : r("", true), a(l).visible("completeRate") ? (n(), s(e, { key: "completeRate", prop: "completeRate", "show-overflow-tooltip": true, label: "完成率", align: "center" })) : r("", true)], 64)) : r("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[t, a(c).loading]])]);
  };
} }, Z = H(K, [["__scopeId", "data-v-1274d8ba"]]);
export {
  Z as default
};
