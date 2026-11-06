import { ref as i } from "vue";
import { inject as B } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as r } from "vue";
import { withDirectives as D } from "vue";
import { unref as l } from "vue";
import { createBlock as b } from "vue";
import { withCtx as p } from "vue";
import { createVNode as e } from "vue";
import { toDisplayString as C } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as T } from "element-plus";
import { x as V, D as H, o as P, iv as L, P as N } from "../../../../../../shared/runtime.js";
import { k as E } from "../../../../../../modules/index-dfff0f60.js";
import F from "../../../../../contract/standing-book/common/components/record/file-download.vue.js";
const M = { class: "table-container" }, R = { key: 0 }, U = { key: 1 }, q = { key: 1 }, G = { __name: "payment", setup(S) {
  const s = i(), { table_item_data: f } = B("common"), { crud: o } = V({ title: "付款记录", crudApi: { get: E } }, s);
  o.query.id = f.value.id;
  const g = i([["paymentDate", ["parse-time", "{y}-{m}-{d}"]], ["paymentAmount", ["to-thousand", H.YUAN]]]), { maxHeight: h } = P({ mainBox: ".detail-record", extraBox: [".el-drawer__header", ".header-container", ".box-container"], wrapperBox: ".table-container", navbar: false, paginate: true, minHeight: 300, clientHRepMainH: true }, o.data), m = i(false), c = i([]);
  function x(d) {
    c.value = d.attachments, m.value = true;
  }
  return (d, u) => {
    const t = A, v = y("common-button"), k = y("common-table"), w = T;
    return n(), r("div", M, [D((n(), b(k, { ref_key: "table_ref", ref: s, data: l(o).data, "data-format": g.value, "empty-text": l(o).emptyText, "max-height": l(h) }, { default: p(() => [e(t, { align: "center", label: "序号", type: "index" }), e(t, { align: "center", label: "付款日期", prop: "paymentDate", width: "100" }), e(t, { align: "center", label: "付款类型", prop: "paymentType" }, { default: p(({ row: a }) => [a.paymentType && a.paymentType !== "-" ? (n(), r("span", R, C(l(L).VL[a.paymentType]), 1)) : (n(), r("span", U, "-"))]), _: 1 }), e(t, { align: "center", label: "付款属性", prop: "paymentAttributeName" }), e(t, { align: "center", label: "付款金额", prop: "paymentAmount" }), e(t, { align: "center", label: "付款单位", "min-width": "160", prop: "contractSignBody.name" }), e(t, { align: "center", label: "收款单位", "min-width": "160", prop: "supplierName" }), e(t, { align: "center", label: "付款行", "min-width": "140", prop: "paymentBank" }), e(t, { align: "center", label: "办理人", prop: "paymentPerson.name" }), e(t, { align: "center", label: "附件", prop: "attachment", width: "80" }, { default: p(({ row: a }) => {
      var _;
      return [(_ = a.attachments) != null && _.length ? (n(), b(v, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: ($) => x(a) }, null, 8, ["onClick"])) : (n(), r("span", q, "-"))];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[w, l(o).loading]]), e(N), e(F, { "file-list": c.value, modelValue: m.value, "onUpdate:modelValue": u[0] || (u[0] = (a) => m.value = a) }, null, 8, ["file-list", "modelValue"])]);
  };
} };
export {
  G as default
};
