import { ref as h } from "vue";
import { computed as U } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as e } from "vue";
import { createElementBlock as d } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as r } from "vue";
import { unref as a } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as l } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as s } from "vue";
import { Fragment as B } from "vue";
import { renderList as I } from "vue";
import { toDisplayString as _ } from "vue";
import { ElTableColumn as R } from "element-plus";
import { InfoFilled as j } from "@element-plus/icons-vue";
import { ElIcon as F } from "element-plus";
import { ElTooltip as H } from "element-plus";
import { vLoading as $ } from "element-plus";
import { c as M, _ as O } from "./module/header.vue.js";
import { G } from "../../../../../../modules/contract-9b18cc88.js";
import { _ as K, t as z, x as J, o as Q, iy as W, P as X, ba as Y } from "../../../../../../shared/runtime.js";
const Z = { class: "app-container" }, ee = { class: "head-container" }, te = ["onDblclick"], ae = { key: 0 }, ne = { key: 1 }, oe = { __name: "index", setup(ie) {
  const { decimalPrecision: v } = z(), g = G.payment, x = { add: false, edit: false, del: false, download: false }, b = h(), p = h(false), w = h(), { crud: n, columns: u, CRUD: k } = J({ title: "付款台账", sort: [], permission: { ...g }, optShow: { ...x }, crudApi: { ...M }, invisibleColumns: ["contractAmount"], hasPagination: true }, b), D = U(() => [["actuallyPaymentAmount", ["to-thousand", v.value.contract]], ["paymentDate", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: P } = Q({ wrapperBox: ".paymentLedger", paginate: true, extraHeight: 120 });
  function N(o) {
    w.value = o.id, p.value = true;
  }
  k.HOOK.beforeRefresh = () => {
    var o;
    ((o = n.query.createTime) == null ? void 0 : o.length) > 0 ? (n.query.startDate = n.query.createTime[0], n.query.endDate = n.query.createTime[1]) : (n.query.startDate = void 0, n.query.endDate = void 0);
  };
  function A(o) {
    return Y(o, { props: [["actuallyPaymentAmount", v.value.contract]], toThousandFields: ["actuallyPaymentAmount"] });
  }
  return (o, y) => {
    const i = R, C = j, S = F, q = H, L = E("common-table"), T = $;
    return e(), d("div", Z, [m("div", ee, [r(a(O))]), V((e(), l(L, { ref_key: "tableRef", ref: b, data: a(n).data, "empty-text": a(n).emptyText, "max-height": a(P), style: { width: "100%" }, "data-format": D.value, showEmptySymbol: false, stripe: false, "show-summary": "", "summary-method": A }, { default: c(() => [r(i, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(u).visible("paymentDate") ? (e(), l(i, { key: "paymentDate", prop: "paymentDate", label: "付款日期", align: "center", width: "100" })) : s("", true), a(u).visible("paymentUnit") ? (e(), l(i, { key: "paymentUnit", prop: "paymentUnit", "show-overflow-tooltip": true, label: "付款单位", align: "center", "min-width": "140" })) : s("", true), a(u).visible("receivingUnit") ? (e(), l(i, { key: "receivingUnit", prop: "receivingUnit", "show-overflow-tooltip": true, label: "收款单位", align: "center", "min-width": "140" })) : s("", true), a(u).visible("actuallyPaymentAmount") ? (e(), l(i, { key: "actuallyPaymentAmount", prop: "actuallyPaymentAmount", label: "实付金额", align: "center", "min-width": "100" })) : s("", true), r(i, { key: "attachments", prop: "attachments", label: "附件", align: "center", "show-overflow-tooltip": true, "min-width": "160" }, { header: c(() => [r(q, { effect: "light", content: "双击可预览附件", placement: "top" }, { default: c(() => [m("div", null, [y[1] || (y[1] = m("span", null, "附件", -1)), r(S, null, { default: c(() => [r(C)]), _: 1 })])]), _: 1 })]), default: c((t) => [t.row.attachments && t.row.attachments.length > 0 ? (e(true), d(B, { key: 0 }, I(t.row.attachments, (f) => (e(), d("div", { key: f.id }, [m("div", { style: { cursor: "pointer" }, onDblclick: (re) => N(f) }, _(f.name), 41, te)]))), 128)) : s("", true)]), _: 1 }), a(u).visible("serialNumber") ? (e(), l(i, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "所属项目或订单", align: "center", "min-width": "180" }, { default: c((t) => [t.row.serialNumber ? (e(), d("div", ae, _(t.row.serialNumber), 1)) : (e(), d("div", ne, [m("div", null, _(t.row.projectNameList ? t.row.projectNameList.join(",") : ""), 1), m("div", null, _(t.row.serialNumberList ? t.row.serialNumberList.join(",") : ""), 1)]))]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[T, a(n).loading]]), p.value ? (e(), l(W, { key: 0, isVisible: p.value, showType: "attachment", id: w.value, onClose: y[0] || (y[0] = (t) => p.value = false) }, null, 8, ["isVisible", "id"])) : s("", true), r(a(X))]);
  };
} }, ue = K(oe, [["__scopeId", "data-v-7343774f"]]);
export {
  ue as default
};
