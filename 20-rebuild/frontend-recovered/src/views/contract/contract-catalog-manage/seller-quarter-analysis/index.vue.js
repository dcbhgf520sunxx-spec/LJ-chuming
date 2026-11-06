import { ref as m } from "vue";
import { computed as P } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as w } from "vue";
import { withCtx as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as n } from "vue";
import { createCommentVNode as s } from "vue";
import { Fragment as b } from "vue";
import { renderList as I } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as T } from "vue";
import { ElTableColumn as R } from "element-plus";
import { ElCard as E } from "element-plus";
import { vLoading as H } from "element-plus";
import { c as O, m as B } from "./module/header.vue.js";
import { h as F } from "../../../../modules/contract-9b18cc88.js";
import { _ as M, x as U, o as q, io as K, bV as Q, ba as Y } from "../../../../shared/runtime.js";
const z = { class: "app-container" }, G = { __name: "index", setup(J) {
  const D = { add: false, edit: false, del: false, download: false }, x = m(), C = m(), p = m([]), i = m([{ showText: "合同额" }, { showText: "排名" }]), g = m([]), L = P(() => [["totalAmount", ["to-thousand-text"]], ["unSignAmount", ["to-thousand-text"]], ["lastYearAmount", ["to-thousand-text"]], ["coordinateAmount", ["to-thousand-text"]], ["coordinateProjectAmount", ["to-thousand-text"]], ["unCoordinateAmount", ["to-thousand-text"]], ["signAmount", ["to-thousand-text"]]]), { crud: y, columns: r, CRUD: V } = U({ title: "汇总分析", sort: [], permission: { ...F }, crudApi: O, dataPath: "listOne", invisibleColumns: [], optShow: { ...D }, hasPagination: false }, x), { maxHeight: S } = q({});
  V.HOOK.handleRefresh = (h, { data: f }) => {
    var d;
    i.value = [{ showText: "合同额" }, { showText: "排名" }], p.value = [];
    let o = 0;
    (d = f.listOne) == null || d.forEach((l, u) => {
      l.rankIndex = u + 1;
      const a = l.secondLevelDeptValue + "_" + (p.value.length + 1);
      p.value.push({ key: a, dataName: l.secondLevelDeptValue }), l[a] = l.totalAmount, i.value[0][a] = l.totalAmount, i.value[1][a] = l.rankIndex, o += l.totalAmount || 0;
    }), i.value[0].summaryAmount = o, f.listTwo.forEach((l, u) => {
      l.rankIndex = u + 1;
    }), g.value = f.listTwo;
  };
  function N(h) {
    return Y(h, { props: [["coordinateAmount", 4], ["unCoordinateAmount", 4], ["coordinateProjectAmount", 4], ["totalAmount", 4]], toThousandFields: ["coordinateAmount", "unCoordinateAmount", "coordinateProjectAmount", "totalAmount"] });
  }
  return (h, f) => {
    const o = R, d = j("common-table"), l = E, u = H;
    return t(), _("div", z, [w(l, null, { default: c(() => [w(e(B), { ref_key: "headerRef", ref: C }, null, 512), A((t(), n(d, { data: i.value, showEmptySymbol: false, returnSourceData: "", style: { width: "100%" } }, { default: c(() => [e(r).visible("showText") ? (t(), n(o, { key: "showText", prop: "showText", "show-overflow-tooltip": true, label: "", align: "center", fixed: "left" })) : s("", true), (t(true), _(b, null, I(p.value, (a) => (t(), _(b, { key: a.key }, [e(r).visible(a.key) ? (t(), n(o, { key: a.key, prop: a.key, "show-overflow-tooltip": true, label: a.dataName, align: "right" }, { default: c(({ row: v }) => [k(T(v.showText === "合同额" ? e(K)(v[a.key], 4) : v[a.key]), 1)]), _: 2 }, 1032, ["prop", "label"])) : s("", true)], 64))), 128)), e(r).visible("summaryAmount") ? (t(), n(o, { key: "summaryAmount", prop: "summaryAmount", "show-overflow-tooltip": true, label: "合计", align: "right" }, { default: c(({ row: a }) => [k(T(a.showText === "合同额" ? e(Q)(a.summaryAmount, 4) : "-"), 1)]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data"])), [[u, e(y).loading]])]), _: 1 }), A((t(), n(d, { ref_key: "tableRef", ref: x, "data-format": L.value, data: g.value, "show-summary": "", "summary-method": N, style: { width: "100%", "margin-top": "10px" }, "max-height": e(S) - 200 }, { default: c(() => [w(o, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), e(r).visible("signerName") ? (t(), n(o, { key: "signerName", prop: "signerName", "show-overflow-tooltip": true, label: "姓名", width: "120", align: "center" })) : s("", true), e(r).visible("firstLevelDeptValue") ? (t(), n(o, { key: "firstLevelDeptValue", prop: "firstLevelDeptValue", "show-overflow-tooltip": true, label: "所属一级部门名称", align: "center" })) : s("", true), e(r).visible("secondLevelDeptValue") ? (t(), n(o, { key: "secondLevelDeptValue", prop: "secondLevelDeptValue", "show-overflow-tooltip": true, label: "所属二级部门名称", align: "center" })) : s("", true), e(r).visible("unCoordinateAmount") ? (t(), n(o, { key: "unCoordinateAmount", prop: "unCoordinateAmount", "show-overflow-tooltip": true, label: "自主承接", align: "right" })) : s("", true), e(r).visible("coordinateAmount") ? (t(), n(o, { key: "coordinateAmount", prop: "coordinateAmount", "show-overflow-tooltip": true, label: "配合项目", align: "right" })) : s("", true), e(r).visible("coordinateProjectAmount") ? (t(), n(o, { key: "coordinateProjectAmount", prop: "coordinateProjectAmount", "show-overflow-tooltip": true, label: "配合项目合同额", align: "right" })) : s("", true), e(r).visible("totalAmount") ? (t(), n(o, { key: "totalAmount", prop: "totalAmount", "show-overflow-tooltip": true, label: "累计合同额", align: "right" })) : s("", true), e(r).visible("rankIndex") ? (t(), n(o, { key: "rankIndex", prop: "rankIndex", "show-overflow-tooltip": true, label: "排名", align: "center" })) : s("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[u, e(y).loading]])]);
  };
} }, ee = M(G, [["__scopeId", "data-v-ba73760e"]]);
export {
  ee as default
};
