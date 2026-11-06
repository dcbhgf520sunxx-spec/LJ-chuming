import { ref as b } from "vue";
import { provide as fe } from "vue";
import { watch as pe } from "vue";
import { resolveComponent as z } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as y } from "vue";
import { withDirectives as D } from "vue";
import { unref as i } from "vue";
import { createBlock as d } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as f } from "vue";
import { createVNode as u } from "vue";
import { Fragment as E } from "vue";
import { renderList as ye } from "vue";
import { nextTick as ve } from "vue";
import { ElMessage as j } from "element-plus";
import { ElTag as _e } from "element-plus";
import { ElTableColumn as ge } from "element-plus";
import { ElDatePicker as we } from "element-plus";
import { ElInputNumber as he } from "element-plus";
import { InfoFilled as be } from "@element-plus/icons-vue";
import { ElIcon as xe } from "element-plus";
import { ElTooltip as Ae } from "element-plus";
import { ElInput as ke } from "element-plus";
import { ElPopconfirm as Ie } from "element-plus";
import { vLoading as Te } from "element-plus";
import { c as C, e as Ce } from "../../../../../../../../modules/invoice-bc8acad8.js";
import { _ as Se, t as Ne, x as Re, o as Ve, bV as U, p as De, ia as Ee, S as Ue, bD as O, G as S, c3 as I, P as Oe, iy as Pe, fK as q, ba as Me } from "../../../../../../../../shared/runtime.js";
import { H as $e } from "../../../../../../../../modules/contract-9b18cc88.js";
import { _ as Be } from "../../../../../../../../modules/UploadBtn-b4cfb47a.js";
import ze from "./form.vue.js";
const Fe = { class: "app-container" }, je = { key: 1 }, qe = { key: 1 }, He = ["onDblclick"], Qe = { key: 0 }, Ge = { key: 1 }, Je = { __name: "index", props: { currentRow: { type: Object, default: () => {
} }, visibleValue: { type: Boolean, default: false }, propertyType: { type: [Number, String], default: void 0 } }, emits: ["success"], setup(v, { emit: H }) {
  const { decimalPrecision: x } = Ne(), w = $e.invoice, N = H, Q = { add: true, edit: false, del: false, download: false }, A = v, P = b(), M = b({}), _ = b(0), R = b([]), T = b(false), $ = b();
  fe("totalAmount", _);
  const { crud: c, CRUD: k } = Re({ title: "收票填报", sort: [], permission: { ...w }, optShow: { ...Q }, crudApi: { ...C }, requiredQuery: ["orderId"], invisibleColumns: ["haveInvoiceAmount", "collectionMode", "invoiceType", "collectionDepositBank", "collectionBankAccount", "paymentBankAccount", "paymentDepositBank", "auditorName", "auditTime"], hasPagination: true }, P), B = { receiveInvoiceDate: [{ required: true, message: "请选择收票日期", trigger: "change" }], invoiceAmount: [{ validator: (t, n) => !!t, message: "请选择收票额", trigger: "change", type: "number" }], taxRate: [{ validator: (t, n) => n.invoiceType !== O.RECEIPT.V ? !!t : true, message: "请输入税率", trigger: "blur" }], invoiceType: [{ required: true, message: "请选择发票类型", trigger: "change" }], invoiceSerialNumber: [{ required: true, message: "请输入发票号", trigger: "blur" }] };
  function G({ row: t, column: n }) {
    if (!t) return;
    const r = B;
    let p = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[n.property] === false && (p = q(n.property, r[n.property], t)), p && (t.verify[n.property] = true)), p ? "" : "mask-td";
  }
  const { maxHeight: J } = Ve({ wrapperBox: ".pay-invoice", paginate: true, extraHeight: 40 });
  pe(() => A.visibleValue, (t) => {
    t && (c.query.orderId = A.currentRow.id, c.toQuery());
  }, { deep: true, immediate: true });
  function K(t) {
    if (A.currentRow.settlementAmount && (_.value = 0, c.data.map((n) => {
      n.invoiceAmount && (_.value += n.invoiceAmount);
    }), _.value > A.currentRow.settlementAmount)) {
      const n = t.invoiceAmount - (_.value - A.currentRow.settlementAmount);
      ve(() => {
        t.invoiceAmount = n || 0, _.value = 0, c.data.map((r) => {
          r.invoiceAmount && (_.value += r.invoiceAmount);
        });
      });
    }
    L(t);
  }
  function L(t) {
    t.invoiceAmount && t.taxRate && (t.tax = t.invoiceAmount * t.taxRate / 100);
  }
  async function Y(t) {
    try {
      await Ce({ id: t.id, auditStatus: I.PASS.V }), c.notify("审核成功", k.NOTIFICATION_TYPE.SUCCESS), c.toQuery(), N("success");
    } catch (n) {
      console.log("审核失败", n);
    }
  }
  function W(t) {
    M.value = JSON.parse(JSON.stringify(t)), t.isModify = true;
  }
  async function X(t) {
    try {
      await C.del(t.id), c.notify("删除成功", k.NOTIFICATION_TYPE.SUCCESS), c.toQuery(), N("success");
    } catch (n) {
      console.log("删除失败", n);
    }
  }
  function Z(t) {
    if (t.isModify = false, t.id) t = Object.assign(t, JSON.parse(JSON.stringify(M.value)));
    else {
      const n = c.data.findIndex((r) => r.dataIndex === t.dataIndex);
      c.data.splice(n, 1);
    }
  }
  async function ee(t) {
    if (t.invoiceAmount === 0) {
      j.error("收票额必须大于0");
      return;
    }
    const n = B;
    let r = true;
    t.verify = {};
    for (const o in n) t.verify[o] = q(o, n[o], t), t.verify[o] || (r = false);
    if (!r) {
      j.error("请填写表格中标红数据");
      return;
    }
    const p = t.id ? "修改" : "新增";
    try {
      t.id ? (t.attachmentIds = t.files ? t.files.map((o) => o.id) : t.attachments ? t.attachments.map((o) => o.id) : void 0, await C.edit(t)) : await C.add(t), c.notify(`${p}成功`, k.NOTIFICATION_TYPE.SUCCESS), c.toQuery();
    } catch (o) {
      console.log(p, o);
    }
  }
  function te(t) {
    $.value = t.id, T.value = true;
  }
  function ne(t) {
    return Me(t, { props: [["invoiceAmount", x.value.contract]], toThousandFields: ["invoiceAmount"] });
  }
  return k.HOOK.handleRefresh = (t, n) => {
    _.value = 0, R.value = [], n.data.content.map((r) => {
      r.dataIndex = r.id + "id", r.invoiceAmount && (_.value += r.invoiceAmount), r.invoiceSerialNumber && R.value.push({ invoiceSerialNumber: r.invoiceSerialNumber, dataIndex: r.dataIndex });
    });
  }, k.HOOK.afterAddSuccess = () => {
    N("success");
  }, (t, n) => {
    const r = z("common-button"), p = _e, o = ge, ie = we, ae = he, oe = be, re = xe, le = Ae, ue = ke, V = Ie, se = z("common-table"), ce = F("permission"), de = F("show-thousand"), me = Te;
    return l(), g("div", Fe, [y("div", null, [D((l(), d(r, { type: "primary", size: "default", onClick: i(c).toAdd, style: { "margin-right": "10px" } }, { default: a(() => n[1] || (n[1] = [h("添加")])), _: 1, __: [1] }, 8, ["onClick"])), [[ce, i(w).add]]), v.currentRow.amount ? (l(), d(p, { key: 0, type: "success", size: "large" }, { default: a(() => [h(m(`合同额:${i(U)(v.currentRow.amount, i(x).contract)}`), 1)]), _: 1 })) : f("", true), v.currentRow.settlementAmount ? (l(), d(p, { key: 1, type: "success", size: "large", style: { "margin-left": "5px" } }, { default: a(() => [h(m(`结算额:${i(U)(v.currentRow.settlementAmount, i(x).contract)}`), 1)]), _: 1 })) : f("", true)]), D((l(), d(se, { ref_key: "tableRef", ref: P, data: i(c).data, "empty-text": i(c).emptyText, "max-height": i(J), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", "cell-class-name": G, "return-source-data": "", showEmptySymbol: false, "show-summary": "", "summary-method": ne, stripe: false }, { default: a(() => [u(o, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), u(o, { key: "receiveInvoiceDate", prop: "receiveInvoiceDate", label: "*收票日期", align: "center", width: "160" }, { default: a((e) => [e.row.isModify ? (l(), d(ie, { key: 0, modelValue: e.row.receiveInvoiceDate, "onUpdate:modelValue": (s) => e.row.receiveInvoiceDate = s, type: "date", size: "default", "value-format": "x", placeholder: "选择日期", disabledDate: (s) => s.getTime() > (/* @__PURE__ */ new Date()).getTime(), style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate"])) : (l(), g("div", je, m(e.row.receiveInvoiceDate ? i(De)(e.row.receiveInvoiceDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), u(o, { key: "invoiceAmount1", prop: "invoiceAmount1", label: "*收票额", align: "center", class: "money-column" }, { default: a(() => [u(o, { key: "invoiceAmount", prop: "invoiceAmount", label: "小写", align: "center", "min-width": "110" }, { default: a((e) => [e.row.isModify ? D((l(), d(ae, { key: 0, modelValue: e.row.invoiceAmount, "onUpdate:modelValue": (s) => e.row.invoiceAmount = s, modelModifiers: { number: true }, min: 0, max: v.currentRow.settlementAmount ? v.currentRow.settlementAmount : 999999999999, step: 100, precision: i(x).contract, placeholder: "收票额(元)", "controls-position": "right", onChange: (s) => K(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])), [[de]]) : (l(), g("div", qe, m(e.row.invoiceAmount && e.row.invoiceAmount > 0 ? i(U)(e.row.invoiceAmount, i(x).contract) : e.row.invoiceAmount), 1))]), _: 1 }), u(o, { key: "invoiceAmount2", prop: "invoiceAmount2", label: "大写", align: "center", width: "330", "show-overflow-tooltip": true }, { default: a((e) => [y("div", null, m(e.row.invoiceAmount ? "(" + i(Ee)(e.row.invoiceAmount) + ")" : ""), 1)]), _: 1 })]), _: 1 }), u(o, { key: "attachments", prop: "attachments", label: "附件", align: "center", width: "150", "show-overflow-tooltip": true }, { header: a(() => [u(le, { effect: "light", content: "双击可预览附件", placement: "top" }, { default: a(() => [y("div", null, [n[2] || (n[2] = y("span", null, "附件", -1)), u(re, null, { default: a(() => [u(oe)]), _: 1 })])]), _: 1 })]), default: a((e) => [e.row.isModify ? (l(), d(i(Be), { key: 0, ref: "uploadRef", files: e.row.files, "onUpdate:files": (s) => e.row.files = s, "file-classify": i(Ue).CONTRACT_ATT.V, limit: 1, accept: ".pdf,.jpg,.jpeg,.png" }, null, 8, ["files", "onUpdate:files", "file-classify"])) : f("", true), e.row.attachments && e.row.attachments.length > 0 && !e.row.files ? (l(true), g(E, { key: 1 }, ye(e.row.attachments, (s) => (l(), g("div", { key: s.id }, [y("div", { style: { cursor: "pointer" }, onDblclick: (Ye) => te(s) }, m(s.name), 41, He)]))), 128)) : f("", true)]), _: 1 }), u(o, { key: "invoiceType", prop: "invoiceType", label: "*发票类型", align: "center", width: "120" }, { default: a((e) => [y("div", null, m(e.row.invoiceType ? i(O).VL[e.row.invoiceType] : ""), 1)]), _: 1 }), u(o, { key: "taxRate", prop: "taxRate", label: "税率", align: "center", width: "80" }, { default: a((e) => [e.row.invoiceType !== i(O).RECEIPT.V ? (l(), g("div", Qe, m(e.row.taxRate ? e.row.taxRate + "%" : ""), 1)) : f("", true)]), _: 1 }), u(o, { key: "branchCompanyId", prop: "branchCompanyId", label: "*购方单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: a((e) => [y("div", null, m(e.row.branchCompanyName), 1)]), _: 1 }), u(o, { key: "supplierId", prop: "supplierId", label: "*销售单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: a((e) => [y("div", null, m(e.row.supplierName), 1)]), _: 1 }), u(o, { prop: "invoiceSerialNumber", label: "*发票号码", align: "center", "min-width": "150" }, { default: a((e) => [e.row.isModify ? (l(), d(ue, { key: 0, modelValue: e.row.invoiceSerialNumber, "onUpdate:modelValue": (s) => e.row.invoiceSerialNumber = s, modelModifiers: { trim: true }, type: "text", placeholder: "发票号码", style: { width: "100%" }, maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (l(), g("span", Ge, m(e.row.invoiceSerialNumber), 1))]), _: 1 }), u(o, { key: "applyUserName", prop: "applyUserName", label: "办理人", align: "center", width: "100px" }, { default: a((e) => [y("div", null, m(e.row.applyUserName), 1)]), _: 1 }), u(o, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center", width: "100px" }, { default: a((e) => [y("div", null, m(e.row.auditUserName), 1)]), _: 1 }), i(S)([...i(w).edit, ...i(w).audit]) ? (l(), d(o, { key: 0, label: "操作", width: "190px", align: "center" }, { default: a((e) => [e.row.isModify ? (l(), g(E, { key: 1 }, [u(V, { "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定取消吗?", onConfirm: (s) => Z(e.row, e.$index) }, { reference: a(() => [u(r, { type: "primary", size: "default" }, { default: a(() => n[5] || (n[5] = [h("取消")])), _: 1, __: [5] })]), _: 2 }, 1032, ["onConfirm"]), u(r, { type: "info", plain: "", size: "default", onClick: (s) => ee(e.row) }, { default: a(() => n[6] || (n[6] = [h("保存")])), _: 2, __: [6] }, 1032, ["onClick"])], 64)) : (l(), g(E, { key: 0 }, [e.row.auditStatus === i(I).AUDITING.V && i(S)(i(w).edit) ? (l(), d(r, { key: 0, icon: "el-icon-edit", type: "primary", size: "default", onClick: (s) => W(e.row) }, null, 8, ["onClick"])) : f("", true), e.row.auditStatus === i(I).AUDITING.V && i(S)(i(w).del) ? (l(), d(V, { key: 1, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定删除吗?", onConfirm: (s) => X(e.row) }, { reference: a(() => [u(r, { icon: "el-icon-delete", type: "danger", size: "default" })]), _: 2 }, 1032, ["onConfirm"])) : f("", true), e.row.auditStatus === i(I).AUDITING.V && i(S)(i(w).audit) ? (l(), d(V, { key: 2, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定通过吗?", onConfirm: (s) => Y(e.row) }, { reference: a(() => [u(r, { type: "success", size: "default" }, { default: a(() => n[3] || (n[3] = [h("通过")])), _: 1, __: [3] })]), _: 2 }, 1032, ["onConfirm"])) : f("", true), e.row.auditStatus === i(I).PASS.V ? (l(), d(p, { key: 3, type: "success", class: "pass-tag" }, { default: a(() => n[4] || (n[4] = [h("已复核")])), _: 1, __: [4] })) : f("", true)], 64))]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[me, i(c).loading]]), u(i(Oe)), u(i(ze), { existInvoiceNo: R.value, currentRow: v.currentRow, propertyType: v.propertyType }, null, 8, ["existInvoiceNo", "currentRow", "propertyType"]), T.value ? (l(), d(Pe, { key: 0, isVisible: T.value, showType: "attachment", id: $.value, onClose: n[0] || (n[0] = (e) => T.value = false) }, null, 8, ["isVisible", "id"])) : f("", true)]);
  };
} }, it = Se(Je, [["__scopeId", "data-v-82710de7"]]);
export {
  it as default
};
