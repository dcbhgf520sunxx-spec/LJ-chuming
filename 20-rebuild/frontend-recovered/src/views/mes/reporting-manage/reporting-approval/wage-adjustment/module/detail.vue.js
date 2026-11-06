import { ref as S } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as o } from "vue";
import { withCtx as a } from "vue";
import { unref as l } from "vue";
import { createBlock as h } from "vue";
import { createTextVNode as k } from "vue";
import { createCommentVNode as P } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as n } from "vue";
import { withDirectives as $ } from "vue";
import { ElPopover as H } from "element-plus";
import { ElPopconfirm as Q } from "element-plus";
import { ElDescriptionsItem as W } from "element-plus";
import { ElDescriptions as G } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { ElInput as K } from "element-plus";
import { vLoading as M } from "element-plus";
import { _ as O, gt as X, oz as Y, ib as C, bV as q, qr as Z } from "../../../../../../shared/runtime.js";
const ee = { key: 1, class: "footer" }, te = { key: 0 }, ae = { key: 1 }, oe = { key: 0 }, le = { key: 1 }, ne = { key: 0 }, re = { key: 1 }, ie = { key: 0 }, se = { key: 1 }, ce = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess"], setup(R, { emit: j }) {
  const { CRUD: ue, crud: _, detail: i } = X(), A = j, N = R, b = S(), w = S(false);
  async function x(g) {
    try {
      w.value = true;
      const r = { wageAdjustId: i.id, approvalResult: g, remark: b.value };
      await Z(r), A("auditSuccess");
    } catch (r) {
      console.log("退库(审批流)审核提交", r);
    } finally {
      w.value = false;
    }
  }
  return (g, r) => {
    const y = v("common-button"), z = H, V = Q, d = W, L = G, m = J, B = v("common-table"), F = K, I = v("common-drawer"), T = M;
    return s(), u("div", null, [o(I, { ref: "drawerRef", "before-close": l(_).cancelDetail, "content-loading": l(_).detailLoading, "show-close": true, title: "工价修改", visible: l(_).detailVisible, size: "50%" }, { titleRight: a(() => {
      var e, t;
      return [((t = (e = l(i)) == null ? void 0 : e.approveRecord) == null ? void 0 : t.length) !== 0 ? (s(), h(z, { key: 0, width: 400, placement: "bottom", trigger: "click" }, { reference: a(() => [o(y, { size: "default" }, { default: a(() => r[3] || (r[3] = [k("查看审批记录")])), _: 1, __: [3] })]), default: a(() => {
        var c;
        return [o(Y, { data: ((c = l(i)) == null ? void 0 : c.approveRecord) || [] }, null, 8, ["data"])];
      }), _: 1 })) : P("", true), N.ApprovalFlag ? (s(), u("div", ee, [o(V, { title: "确认通过", onConfirm: r[0] || (r[0] = (c) => x(l(C).PASS.V)) }, { reference: a(() => [o(y, { loading: w.value, class: "filter-item", size: "default", type: "success" }, { default: a(() => r[4] || (r[4] = [k("通过")])), _: 1, __: [4] }, 8, ["loading"])]), _: 1 }), o(V, { title: "确认驳回", onConfirm: r[1] || (r[1] = (c) => x(l(C).REFUSE.V)) }, { reference: a(() => [o(y, { loading: w.value, class: "filter-item", size: "default", type: "danger" }, { default: a(() => r[5] || (r[5] = [k(" 驳回")])), _: 1, __: [5] }, 8, ["loading"])]), _: 1 })])) : P("", true)];
    }), content: a(() => [o(L, { class: "descriptions-style", data: g.detailData, column: 2, size: "large", border: "" }, { default: a(() => [o(d, { align: "center", label: "项目" }, { default: a(() => {
      var e, t, c, f;
      return [p("span", null, n(((t = (e = l(i)) == null ? void 0 : e.project) == null ? void 0 : t.serialNumber) || "-") + " - " + n(((f = (c = l(i)) == null ? void 0 : c.project) == null ? void 0 : f.shortName) || "-"), 1)];
    }), _: 1 }), o(d, { align: "center", label: "单体" }, { default: a(() => {
      var e, t;
      return [p("span", null, n(((t = (e = l(i)) == null ? void 0 : e.monomer) == null ? void 0 : t.name) || "-"), 1)];
    }), _: 1 }), o(d, { align: "center", label: "数量" }, { default: a(() => {
      var e;
      return [p("span", null, n(((e = l(i)) == null ? void 0 : e.totalQuantity) || "-"), 1)];
    }), _: 1 }), o(d, { align: "center", label: "重量" }, { default: a(() => {
      var e;
      return [p("span", null, n(((e = l(i)) == null ? void 0 : e.totalWeight) || "-") + " kg", 1)];
    }), _: 1 }), o(d, { align: "center", label: "工序" }, { default: a(() => {
      var e, t;
      return [p("span", null, n(((t = (e = l(i)) == null ? void 0 : e.process) == null ? void 0 : t.name) || "-"), 1)];
    }), _: 1 }), o(d, { align: "center", label: "车间" }, { default: a(() => {
      var e, t;
      return [p("span", null, n(((t = (e = l(i)) == null ? void 0 : e.workshop) == null ? void 0 : t.name) || "-"), 1)];
    }), _: 1 }), o(d, { align: "center", label: "班组", span: 1 }, { default: a(() => {
      var e, t, c, f;
      return [(t = (e = l(i)) == null ? void 0 : e.teamList) != null && t.length ? (s(), u("span", te, n((f = (c = l(i)) == null ? void 0 : c.teamList) == null ? void 0 : f.map((U) => {
        var E, D;
        return U.name + "-" + ((D = (E = l(i)) == null ? void 0 : E.process) == null ? void 0 : D.name);
      }).join("、 ")), 1)) : (s(), u("span", ae, "全部班组"))];
    }), _: 1 }), o(d, { align: "center", label: "" })]), _: 1 }, 8, ["data"]), $((s(), h(B, { ref: "tableRef", data: l(i).productList, "empty-text": l(_).emptyText, "max-height": g.maxHeight, style: { width: "100%" } }, { default: a(() => [o(m, { label: "序号", type: "index", align: "center", width: "60" }), o(m, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center" }, { default: a((e) => {
      var t;
      return [p("span", null, n(((t = e.row.product) == null ? void 0 : t.serialNumber) || "-"), 1)];
    }), _: 1 }), o(m, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center" }, { default: a((e) => {
      var t;
      return [p("span", null, n(((t = e.row.product) == null ? void 0 : t.specification) || "-"), 1)];
    }), _: 1 }), o(m, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center" }, { default: a((e) => {
      var t;
      return [p("span", null, n(((t = e.row.product) == null ? void 0 : t.quantity) || "-"), 1)];
    }), _: 1 }), o(m, { key: "quotaNumber", prop: "quotaNumber", "show-overflow-tooltip": "", label: "执行定额", align: "center" }, { default: a((e) => [p("span", null, n(e.row.quotaNumber || "-"), 1)]), _: 1 }), o(m, { key: "quotaPrice", prop: "quotaPrice", "show-overflow-tooltip": "", label: "定额工价", align: "center" }, { default: a((e) => [e.row.quotaPrice || e.row.quotaPrice === 0 ? (s(), u("span", oe, n(l(q)(e.row.quotaPrice, 2)) + " 元/" + n(e.row.unit || "?"), 1)) : (s(), u("span", le, "-"))]), _: 1 }), o(m, { key: "newPrice", prop: "newPrice", "show-overflow-tooltip": "", label: "新工价", align: "center" }, { default: a((e) => [e.row.newPrice || e.row.newPrice === 0 ? (s(), u("span", ne, n(l(q)(e.row.newPrice, 2)) + " 元/" + n(e.row.unit || "?"), 1)) : (s(), u("span", re, "-"))]), _: 1 }), o(m, { key: "float", prop: "float", "show-overflow-tooltip": "", label: "浮动", align: "center" }, { default: a((e) => [e.row.newPrice && e.row.quotaPrice ? (s(), u("span", ie, n(l(q)(e.row.newPrice - e.row.quotaPrice, 2)) + " 元/" + n(e.row.unit || "?"), 1)) : (s(), u("span", se, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[T, l(_).loading]]), N.ApprovalFlag ? (s(), h(F, { key: 0, modelValue: b.value, "onUpdate:modelValue": r[2] || (r[2] = (e) => b.value = e), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])) : P("", true)]), _: 1 }, 8, ["before-close", "content-loading", "visible"])]);
  };
} }, me = O(ce, [["__scopeId", "data-v-c5739de7"]]);
export {
  me as default
};
