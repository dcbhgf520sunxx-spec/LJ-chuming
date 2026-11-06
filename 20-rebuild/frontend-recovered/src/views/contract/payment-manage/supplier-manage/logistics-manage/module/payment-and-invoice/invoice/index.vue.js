import { ref as x } from "vue";
import { provide as ge } from "vue";
import { watch as be } from "vue";
import { resolveComponent as M } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as p } from "vue";
import { withDirectives as P } from "vue";
import { unref as i } from "vue";
import { createBlock as m } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as _ } from "vue";
import { createVNode as u } from "vue";
import { Fragment as $ } from "vue";
import { renderList as we } from "vue";
import { nextTick as xe } from "vue";
import { ElMessage as G } from "element-plus";
import { ElTag as ke } from "element-plus";
import { ElTableColumn as Ce } from "element-plus";
import { ElDatePicker as Te } from "element-plus";
import { ElInputNumber as Ie } from "element-plus";
import { InfoFilled as Ae } from "@element-plus/icons-vue";
import { ElIcon as Se } from "element-plus";
import { ElTooltip as Ve } from "element-plus";
import { ElCheckbox as Ne } from "element-plus";
import { ElInput as Re } from "element-plus";
import { ElPopconfirm as Ue } from "element-plus";
import { vLoading as Ee } from "element-plus";
import { l as S, _ as De, t as Oe, x as Me, o as Pe, bV as J, p as $e, i as T, ia as Be, S as ze, bD as I, G as R, c3 as A, P as Fe, iy as je, fK as K, ba as qe } from "../../../../../../../../shared/runtime.js";
import { C as He } from "../../../../../../../../modules/contract-9b18cc88.js";
import { _ as Ge } from "../../../../../../../../modules/UploadBtn-b4cfb47a.js";
import Je from "./form.vue.js";
function Ke(d) {
  return S({ module: "contract", url: "contract/receive-invoice/logistics", method: "get", params: d });
}
function Le(d) {
  return S({ module: "contract", url: "contract/receive-invoice", method: "post", data: d.list });
}
function Qe(d) {
  return S({ module: "contract", url: "contract/receive-invoice", method: "put", data: d });
}
function Ye(d) {
  return S({ module: "contract", url: `contract/receive-invoice/${d}`, method: "delete" });
}
function We(d) {
  return S({ module: "contract", url: "contract/receive-invoice/audit", method: "put", params: d });
}
const U = { get: Ke, add: Le, edit: Qe, del: Ye };
const Xe = { class: "app-container" }, Ze = { key: 1 }, et = { key: 1 }, tt = ["onDblclick"], nt = { key: 1 }, it = { key: 0 }, at = { style: { display: "flex" } }, ot = { style: { "padding-right": "5px" } }, lt = { key: 1 }, rt = { key: 1 }, ct = { __name: "index", props: { currentRow: { type: Object, default: () => {
} }, visibleValue: { type: Boolean, default: false }, propertyType: { type: [Number, String], default: void 0 } }, emits: ["success"], setup(d, { emit: L }) {
  const { decimalPrecision: V } = Oe(), g = He.invoice, E = L, Q = { add: true, edit: false, del: false, download: false }, b = d, B = x(), z = x({}), v = x(0), D = x([]), N = x(false), F = x();
  ge("totalAmount", v);
  const { crud: s, CRUD: w } = Me({ title: "收票填报", sort: [], permission: { ...g }, optShow: { ...Q }, crudApi: { ...U }, invisibleColumns: ["haveInvoiceAmount", "collectionMode", "invoiceType", "collectionDepositBank", "collectionBankAccount", "paymentBankAccount", "paymentDepositBank", "auditorName", "auditTime"], hasPagination: true }, B), j = { receiveInvoiceDate: [{ required: true, message: "请选择收票日期", trigger: "change" }], invoiceAmount: [{ validator: (e, n) => !!T(e), message: "请选择收票额", trigger: "change", type: "number" }], taxRate: [{ validator: (e, n) => n.invoiceType !== I.RECEIPT.V && !n.checked ? T(e) : true, message: "请输入税率", trigger: "blur" }], invoiceType: [{ required: true, message: "请选择发票类型", trigger: "change" }], invoiceSerialNumber: [{ required: true, message: "请输入发票号", trigger: "blur" }] };
  function Y({ row: e, column: n }) {
    if (!e) return;
    const a = j;
    let h = true;
    return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[n.property] === false && (h = K(n.property, a[n.property], e)), h && (e.verify[n.property] = true)), h ? "" : "mask-td";
  }
  const { maxHeight: W } = Pe({ wrapperBox: ".pay-invoice", paginate: true, extraHeight: 40 });
  be(() => b.visibleValue, (e) => {
    e && s.toQuery();
  }, { deep: true, immediate: true });
  function X(e) {
    F.value = e.id, N.value = true;
  }
  function Z(e) {
    e.checked = false, e.boolIncludeTax = true, e.invoiceType === I.RECEIPT.V && (e.taxRate = 0, C(e));
  }
  function ee(e) {
    if (v.value = 0, s.data.map((n) => {
      n.invoiceAmount && (v.value += n.invoiceAmount);
    }), v.value > b.currentRow.freight) {
      const n = e.invoiceAmount - (v.value - b.currentRow.freight);
      xe(() => {
        e.invoiceAmount = n || 0, C(e), v.value = 0, s.data.map((a) => {
          a.invoiceAmount && (v.value += a.invoiceAmount);
        });
      });
    } else C(e);
  }
  function te(e) {
    e.boolIncludeTax = !e.checked, e.taxRate = e.checked ? 0 : e.taxRate, C(e);
  }
  function C(e) {
    e.tax = 0, T(e.invoiceAmount) && e.taxRate && (e.tax = e.invoiceAmount * e.taxRate / 100);
  }
  async function ne(e) {
    try {
      await We({ id: e.id, auditStatus: A.PASS.V }), s.notify("审核成功", w.NOTIFICATION_TYPE.SUCCESS), s.toQuery(), E("success");
    } catch (n) {
      console.log("审核失败", n);
    }
  }
  function ie(e) {
    z.value = JSON.parse(JSON.stringify(e)), e.isModify = true;
  }
  async function ae(e) {
    try {
      await U.del(e.id), s.notify("删除成功", w.NOTIFICATION_TYPE.SUCCESS), s.toQuery(), E("success");
    } catch (n) {
      console.log("删除失败", n);
    }
  }
  function oe(e) {
    if (e.isModify = false, e.id) e = Object.assign(e, JSON.parse(JSON.stringify(z.value)));
    else {
      const n = s.data.findIndex((a) => a.dataIndex === e.dataIndex);
      s.data.splice(n, 1);
    }
  }
  async function le(e) {
    if (e.invoiceAmount === 0) {
      G.error("收票额必须大于0");
      return;
    }
    const n = j;
    let a = true;
    e.verify = {};
    for (const r in n) e.verify[r] = K(r, n[r], e), e.verify[r] || (a = false);
    if (!a) {
      G.error("请填写表格中标红数据");
      return;
    }
    const h = e.id ? "修改" : "新增";
    try {
      e.id ? (e.attachmentIds = e.files ? e.files.map((r) => r.id) : e.attachments ? e.attachments.map((r) => r.id) : void 0, await U.edit(e)) : await U.add(e), s.notify(`${h}成功`, w.NOTIFICATION_TYPE.SUCCESS), s.toQuery();
    } catch (r) {
      console.log(h, r);
    }
  }
  function re(e) {
    return qe(e, { props: [["invoiceAmount", V.value.contract]], toThousandFields: ["invoiceAmount"] });
  }
  return w.HOOK.beforeRefresh = () => {
    s.query.branchCompanyId = b.currentRow.branchCompanyId, s.query.supplierId = b.currentRow.supplierId;
  }, w.HOOK.handleRefresh = (e, n) => {
    v.value = 0, D.value = [], n.data.content.map((a) => {
      a.dataIndex = a.id + "id", a.invoiceAmount && (v.value += a.invoiceAmount), a.invoiceSerialNumber && D.value.push({ invoiceSerialNumber: a.invoiceSerialNumber, dataIndex: a.dataIndex }), a.checked = !a.boolIncludeTax, a.originRate = a.taxRate;
    });
  }, w.HOOK.afterAddSuccess = () => {
    E("success");
  }, (e, n) => {
    const a = M("common-button"), h = ke, r = Ce, ce = Te, q = Ie, ue = Ae, se = Se, de = Ve, me = M("common-select"), pe = Ne, fe = Re, O = Ue, ye = M("common-table"), ve = H("permission"), he = H("show-thousand"), _e = Ee;
    return c(), y("div", Xe, [p("div", null, [P((c(), m(a, { type: "primary", size: "default", onClick: i(s).toAdd, style: { "margin-right": "10px" } }, { default: l(() => n[1] || (n[1] = [k("添加")])), _: 1, __: [1] }, 8, ["onClick"])), [[ve, i(g).add]]), d.currentRow.freight ? (c(), m(h, { key: 0, type: "success", size: "large" }, { default: l(() => [k(f(`运输额:${i(J)(d.currentRow.freight, i(V).contract)}`), 1)]), _: 1 })) : _("", true)]), P((c(), m(ye, { ref_key: "tableRef", ref: B, data: i(s).data, "empty-text": i(s).emptyText, "max-height": i(W), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", "cell-class-name": Y, "return-source-data": "", showEmptySymbol: false, "show-summary": "", "summary-method": re, stripe: false }, { default: l(() => [u(r, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), u(r, { key: "receiveInvoiceDate", prop: "receiveInvoiceDate", label: "收票日期", align: "center", width: "160" }, { default: l((t) => [t.row.isModify ? (c(), m(ce, { key: 0, modelValue: t.row.receiveInvoiceDate, "onUpdate:modelValue": (o) => t.row.receiveInvoiceDate = o, type: "date", size: "default", "value-format": "x", placeholder: "选择日期", disabledDate: (o) => o.getTime() > (/* @__PURE__ */ new Date()).getTime(), style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate"])) : (c(), y("div", Ze, f(t.row.receiveInvoiceDate ? i($e)(t.row.receiveInvoiceDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), u(r, { key: "invoiceAmount1", prop: "invoiceAmount1", label: "收票额", align: "center", class: "money-column" }, { default: l(() => [u(r, { key: "invoiceAmount", prop: "invoiceAmount", label: "小写", align: "center", "min-width": "110" }, { default: l((t) => [t.row.isModify ? P((c(), m(q, { key: 0, modelValue: t.row.invoiceAmount, "onUpdate:modelValue": (o) => t.row.invoiceAmount = o, modelModifiers: { number: true }, min: -9999999999, max: b.currentRow.freight, step: 100, precision: i(V).contract, placeholder: "收票额(元)", "controls-position": "right", onChange: (o) => ee(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])), [[he]]) : (c(), y("div", et, f(i(T)(t.row.invoiceAmount) ? i(J)(t.row.invoiceAmount, i(V).contract) : "-"), 1))]), _: 1 }), u(r, { key: "invoiceAmount2", prop: "invoiceAmount2", label: "大写", align: "center", width: "330", "show-overflow-tooltip": true }, { default: l((t) => [p("div", null, f(t.row.invoiceAmount ? i(Be)(t.row.invoiceAmount) : "-"), 1)]), _: 1 })]), _: 1 }), u(r, { key: "attachments", prop: "attachments", label: "附件", align: "center", width: "150", "show-overflow-tooltip": true }, { header: l(() => [u(de, { effect: "light", content: "双击可预览附件", placement: "top" }, { default: l(() => [p("div", null, [n[2] || (n[2] = p("span", null, "附件", -1)), u(se, null, { default: l(() => [u(ue)]), _: 1 })])]), _: 1 })]), default: l((t) => [t.row.isModify ? (c(), m(i(Ge), { key: 0, ref: "uploadRef", files: t.row.files, "onUpdate:files": (o) => t.row.files = o, "file-classify": i(ze).CONTRACT_ATT.V, limit: 1, accept: ".pdf,.jpg,.jpeg,.png" }, null, 8, ["files", "onUpdate:files", "file-classify"])) : _("", true), t.row.attachments && t.row.attachments.length > 0 && !t.row.files ? (c(true), y($, { key: 1 }, we(t.row.attachments, (o) => (c(), y("div", { key: o.id }, [p("div", { style: { cursor: "pointer" }, onDblclick: (dt) => X(o) }, f(o.name), 41, tt)]))), 128)) : _("", true)]), _: 1 }), u(r, { key: "invoiceType", prop: "invoiceType", label: "发票类型", align: "center", width: "180" }, { default: l((t) => [t.row.isModify ? (c(), m(me, { key: 0, modelValue: t.row.invoiceType, "onUpdate:modelValue": (o) => t.row.invoiceType = o, options: i(I).ENUM, type: "enum", size: "default", clearable: "", class: "filter-item", placeholder: "发票类型", style: { width: "100%" }, onChange: (o) => Z(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (c(), y("div", nt, f(t.row.invoiceType ? i(I).VL[t.row.invoiceType] : ""), 1))]), _: 1 }), u(r, { key: "taxRate", prop: "taxRate", label: "税率", align: "center", width: "150" }, { default: l((t) => [t.row.invoiceType !== i(I).RECEIPT.V && t.row.isModify ? (c(), y("div", it, [p("div", at, [p("div", ot, [u(pe, { modelValue: t.row.checked, "onUpdate:modelValue": (o) => t.row.checked = o, label: "免税", size: "large", onChange: (o) => te(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), u(q, { modelValue: t.row.taxRate, "onUpdate:modelValue": (o) => t.row.taxRate = o, step: 1, min: 0, max: 100, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "100px", "text-align": "center" }, placeholder: "0-100", disabled: t.row.checked, onChange: (o) => C(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"]), n[3] || (n[3] = p("span", { style: { "line-height": "40px" } }, "%", -1))])])) : (c(), y("div", lt, f(t.row.checked && t.row.invoiceType ? "免税" : i(T)(t.row.taxRate) ? t.row.taxRate + "%" : "-"), 1))]), _: 1 }), u(r, { key: "branchCompanyId", prop: "branchCompanyId", label: "购方单位", align: "center", "show-overflow-tooltip": true }, { default: l((t) => [p("div", null, f(t.row.branchCompanyName), 1)]), _: 1 }), u(r, { key: "supplierId", prop: "supplierId", label: "销售单位", align: "center", "show-overflow-tooltip": true }, { default: l((t) => [p("div", null, f(t.row.supplierName), 1)]), _: 1 }), u(r, { prop: "invoiceSerialNumber", label: "发票号码", align: "center", width: "120" }, { default: l((t) => [t.row.isModify ? (c(), m(fe, { key: 0, modelValue: t.row.invoiceSerialNumber, "onUpdate:modelValue": (o) => t.row.invoiceSerialNumber = o, modelModifiers: { trim: true }, type: "text", style: { width: "100%" }, placeholder: "发票号码", maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (c(), y("span", rt, f(t.row.invoiceSerialNumber), 1))]), _: 1 }), u(r, { key: "applyUserName", prop: "applyUserName", label: "办理人", align: "center", width: "100px" }, { default: l((t) => [p("div", null, f(t.row.applyUserName), 1)]), _: 1 }), u(r, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center", width: "100px" }, { default: l((t) => [p("div", null, f(t.row.auditUserName), 1)]), _: 1 }), i(R)([...i(g).edit, ...i(g).audit]) ? (c(), m(r, { key: 0, label: "操作", width: "190px", align: "center" }, { default: l((t) => [t.row.isModify ? (c(), y($, { key: 1 }, [u(O, { "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定取消吗?", onConfirm: (o) => oe(t.row, t.$index) }, { reference: l(() => [u(a, { type: "primary", size: "default" }, { default: l(() => n[6] || (n[6] = [k("取消")])), _: 1, __: [6] })]), _: 2 }, 1032, ["onConfirm"]), u(a, { type: "info", plain: "", size: "default", onClick: (o) => le(t.row) }, { default: l(() => n[7] || (n[7] = [k("保存")])), _: 2, __: [7] }, 1032, ["onClick"])], 64)) : (c(), y($, { key: 0 }, [t.row.auditStatus === i(A).AUDITING.V && i(R)(i(g).edit) ? (c(), m(a, { key: 0, icon: "el-icon-edit", type: "primary", size: "default", onClick: (o) => ie(t.row) }, null, 8, ["onClick"])) : _("", true), t.row.auditStatus === i(A).AUDITING.V && i(R)(i(g).del) ? (c(), m(O, { key: 1, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定删除吗?", onConfirm: (o) => ae(t.row) }, { reference: l(() => [u(a, { icon: "el-icon-delete", type: "danger", size: "default" })]), _: 2 }, 1032, ["onConfirm"])) : _("", true), t.row.auditStatus === i(A).AUDITING.V && i(R)(i(g).audit) ? (c(), m(O, { key: 2, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定通过吗?", onConfirm: (o) => ne(t.row) }, { reference: l(() => [u(a, { type: "success", size: "default" }, { default: l(() => n[4] || (n[4] = [k("通过")])), _: 1, __: [4] })]), _: 2 }, 1032, ["onConfirm"])) : _("", true), t.row.auditStatus === i(A).PASS.V ? (c(), m(h, { key: 3, type: "success", class: "pass-tag" }, { default: l(() => n[5] || (n[5] = [k("已复核")])), _: 1, __: [5] })) : _("", true)], 64))]), _: 1 })) : _("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[_e, i(s).loading]]), u(i(Fe)), u(i(Je), { existInvoiceNo: D.value, currentRow: d.currentRow, propertyType: d.propertyType }, null, 8, ["existInvoiceNo", "currentRow", "propertyType"]), N.value ? (c(), m(je, { key: 0, isVisible: N.value, showType: "attachment", id: F.value, onClose: n[0] || (n[0] = (t) => N.value = false) }, null, 8, ["isVisible", "id"])) : _("", true)]);
  };
} }, ht = De(ct, [["__scopeId", "data-v-afd4c33c"]]);
export {
  ht as default
};
