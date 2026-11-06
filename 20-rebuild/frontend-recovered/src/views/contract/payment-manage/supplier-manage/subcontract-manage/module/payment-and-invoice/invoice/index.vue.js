import { ref as b } from "vue";
import { provide as ve } from "vue";
import { watch as _e } from "vue";
import { resolveComponent as q } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as m } from "vue";
import { withDirectives as E } from "vue";
import { unref as i } from "vue";
import { createBlock as d } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as v } from "vue";
import { createVNode as u } from "vue";
import { Fragment as O } from "vue";
import { renderList as ge } from "vue";
import { nextTick as he } from "vue";
import { ElMessage as Q } from "element-plus";
import { ElTag as we } from "element-plus";
import { ElTableColumn as be } from "element-plus";
import { ElDatePicker as xe } from "element-plus";
import { ElInputNumber as ke } from "element-plus";
import { InfoFilled as Ae } from "@element-plus/icons-vue";
import { ElIcon as Te } from "element-plus";
import { ElTooltip as Ce } from "element-plus";
import { ElCheckbox as Ie } from "element-plus";
import { ElInput as Se } from "element-plus";
import { ElPopconfirm as Ne } from "element-plus";
import { vLoading as Re } from "element-plus";
import { c as S, e as Ve } from "../../../../../../../../modules/invoice-bc8acad8.js";
import { _ as Ue, t as De, x as Ee, o as Oe, jF as Me, bV as M, p as Pe, i as T, ia as $e, S as Be, bD as P, G as N, c3 as C, P as ze, iy as Fe, fK as G, ba as je } from "../../../../../../../../shared/runtime.js";
import { I as qe } from "../../../../../../../../modules/contract-9b18cc88.js";
import He from "./form.vue.js";
import { _ as Qe } from "../../../../../../../../modules/UploadBtn-b4cfb47a.js";
const Ge = { class: "app-container" }, Je = { key: 1 }, Ke = { key: 1 }, Le = ["onDblclick"], Ye = { key: 0 }, We = { style: { display: "flex" } }, Xe = { style: { "padding-right": "5px" } }, Ze = { key: 1 }, et = { key: 1 }, tt = { __name: "index", props: { currentRow: { type: Object, default: () => {
} }, visibleValue: { type: Boolean, default: false }, propertyType: { type: [Number, String], default: void 0 } }, emits: ["success"], setup(_, { emit: J }) {
  const { decimalPrecision: x } = De(), h = qe.invoice, R = J, K = { add: true, edit: false, del: false, download: false }, k = _, $ = b(), B = b({}), g = b(0), V = b([]), I = b(false), z = b();
  ve("totalAmount", g);
  const { crud: c, CRUD: A } = Ee({ title: "收票填报", sort: [], permission: { ...h }, optShow: { ...K }, crudApi: { ...S }, requiredQuery: ["orderId"], invisibleColumns: ["haveInvoiceAmount", "collectionMode", "invoiceType", "collectionDepositBank", "collectionBankAccount", "paymentBankAccount", "paymentDepositBank", "auditorName", "auditTime"], hasPagination: true }, $), F = { receiveInvoiceDate: [{ required: true, message: "请选择收票日期", trigger: "change" }], invoiceAmount: [{ validator: (t, n) => !!T(t), message: "请选择收票额", trigger: "change", type: "number" }], taxRate: [{ validator: (t, n) => n.invoiceType !== P.RECEIPT.V && !n.checked ? T(t) : true, message: "请输入税率", trigger: "blur" }], invoiceType: [{ required: true, message: "请选择发票类型", trigger: "change" }], invoiceSerialNumber: [{ required: true, message: "请输入发票号", trigger: "blur" }] };
  function L({ row: t, column: n }) {
    if (!t) return;
    const a = F;
    let f = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[n.property] === false && (f = G(n.property, a[n.property], t)), f && (t.verify[n.property] = true)), f ? "" : "mask-td";
  }
  const { maxHeight: Y } = Oe({ wrapperBox: ".subcontract-invoice", paginate: true, extraHeight: 40 });
  _e(() => k.visibleValue, (t) => {
    t && (c.query.orderId = k.currentRow.id, c.query.propertyType = Me.SUBCONTRACT.V, c.toQuery());
  }, { deep: true, immediate: true });
  function W(t) {
    if (k.currentRow.settlementAmount && (g.value = 0, c.data.map((n) => {
      n.invoiceAmount && (g.value += n.invoiceAmount);
    }), g.value > k.currentRow.settlementAmount)) {
      const n = t.invoiceAmount - (g.value - k.currentRow.settlementAmount);
      he(() => {
        t.invoiceAmount = n || 0, g.value = 0, c.data.map((a) => {
          a.invoiceAmount && (g.value += a.invoiceAmount);
        });
      });
    }
    U(t);
  }
  function X(t) {
    t.boolIncludeTax = !t.checked, t.taxRate = t.checked ? 0 : t.originRate, U(t);
  }
  function U(t) {
    t.tax = 0, T(t.invoiceAmount) && t.taxRate && (t.tax = t.invoiceAmount * t.taxRate / 100);
  }
  async function Z(t) {
    try {
      await Ve({ id: t.id, auditStatus: C.PASS.V }), c.notify("审核成功", A.NOTIFICATION_TYPE.SUCCESS), c.toQuery(), R("success");
    } catch (n) {
      console.log("审核失败", n);
    }
  }
  function ee(t) {
    B.value = JSON.parse(JSON.stringify(t)), t.isModify = true;
  }
  async function te(t) {
    try {
      await S.del(t.id), c.notify("删除成功", A.NOTIFICATION_TYPE.SUCCESS), c.toQuery(), R("success");
    } catch (n) {
      console.log("删除失败", n);
    }
  }
  function ne(t) {
    if (t.isModify = false, t.id) t = Object.assign(t, JSON.parse(JSON.stringify(B.value)));
    else {
      const n = c.data.findIndex((a) => a.dataIndex === t.dataIndex);
      c.data.splice(n, 1);
    }
  }
  async function ie(t) {
    if (t.invoiceAmount === 0) {
      Q.error("收票额必须大于0");
      return;
    }
    const n = F;
    let a = true;
    t.verify = {};
    for (const l in n) t.verify[l] = G(l, n[l], t), t.verify[l] || (a = false);
    if (!a) {
      Q.error("请填写表格中标红数据");
      return;
    }
    const f = t.id ? "修改" : "新增";
    try {
      t.id ? (t.attachmentIds = t.files ? t.files.map((l) => l.id) : t.attachments ? t.attachments.map((l) => l.id) : void 0, await S.edit(t)) : await S.add(t), c.notify(`${f}成功`, A.NOTIFICATION_TYPE.SUCCESS), c.toQuery();
    } catch (l) {
      console.log(f, l);
    }
  }
  function ae(t) {
    z.value = t.id, I.value = true;
  }
  function oe(t) {
    return je(t, { props: [["invoiceAmount", x.value.contract]], toThousandFields: ["invoiceAmount"] });
  }
  return A.HOOK.handleRefresh = (t, n) => {
    g.value = 0, V.value = [], n.data.content.map((a) => {
      a.dataIndex = a.id + "id", a.invoiceAmount && (g.value += a.invoiceAmount), a.invoiceSerialNumber && V.value.push({ invoiceSerialNumber: a.invoiceSerialNumber, dataIndex: a.dataIndex }), a.checked = !a.boolIncludeTax, a.originRate = a.taxRate;
    });
  }, A.HOOK.afterAddSuccess = () => {
    R("success");
  }, (t, n) => {
    const a = q("common-button"), f = we, l = be, le = xe, j = ke, re = Ae, ue = Te, se = Ce, ce = Ie, de = Se, D = Ne, me = q("common-table"), pe = H("permission"), fe = H("show-thousand"), ye = Re;
    return s(), y("div", Ge, [m("div", null, [E((s(), d(a, { type: "primary", size: "default", onClick: i(c).toAdd, style: { "margin-right": "10px" } }, { default: o(() => n[1] || (n[1] = [w("添加")])), _: 1, __: [1] }, 8, ["onClick"])), [[pe, i(h).add]]), _.currentRow.amount ? (s(), d(f, { key: 0, type: "success", size: "large" }, { default: o(() => [w(p(`合同额:${i(M)(_.currentRow.amount, i(x).contract)}`), 1)]), _: 1 })) : v("", true), _.currentRow.settlementAmount ? (s(), d(f, { key: 1, type: "success", size: "large", style: { "margin-left": "5px" } }, { default: o(() => [w(p(`结算额:${i(M)(_.currentRow.settlementAmount, i(x).contract)}`), 1)]), _: 1 })) : v("", true)]), E((s(), d(me, { ref_key: "tableRef", ref: $, data: i(c).data, "empty-text": i(c).emptyText, "max-height": i(Y), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", "cell-class-name": L, "return-source-data": "", showEmptySymbol: false, "show-summary": "", "summary-method": oe, stripe: false }, { default: o(() => [u(l, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), u(l, { key: "receiveInvoiceDate", prop: "receiveInvoiceDate", label: "收票日期", align: "center", width: "160" }, { default: o((e) => [e.row.isModify ? (s(), d(le, { key: 0, modelValue: e.row.receiveInvoiceDate, "onUpdate:modelValue": (r) => e.row.receiveInvoiceDate = r, type: "date", size: "default", "value-format": "x", placeholder: "选择日期", disabledDate: (r) => r.getTime() > (/* @__PURE__ */ new Date()).getTime(), style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate"])) : (s(), y("div", Je, p(e.row.receiveInvoiceDate ? i(Pe)(e.row.receiveInvoiceDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), u(l, { key: "invoiceAmount1", prop: "invoiceAmount1", label: "收票额", align: "center", class: "money-column" }, { default: o(() => [u(l, { key: "invoiceAmount", prop: "invoiceAmount", label: "小写", align: "center", "min-width": "110" }, { default: o((e) => [e.row.isModify ? E((s(), d(j, { key: 0, modelValue: e.row.invoiceAmount, "onUpdate:modelValue": (r) => e.row.invoiceAmount = r, modelModifiers: { number: true }, min: -9999999999, max: _.currentRow.settlementAmount ? _.currentRow.settlementAmount : 999999999999, step: 100, precision: i(x).contract, placeholder: "收票额(元)", "controls-position": "right", onChange: (r) => W(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])), [[fe]]) : (s(), y("div", Ke, p(i(T)(e.row.invoiceAmount) ? i(M)(e.row.invoiceAmount, i(x).contract) : "-"), 1))]), _: 1 }), u(l, { key: "invoiceAmount2", prop: "invoiceAmount2", label: "大写", align: "center", width: "330", "show-overflow-tooltip": true }, { default: o((e) => [m("div", null, p(e.row.invoiceAmount ? i($e)(e.row.invoiceAmount) : ""), 1)]), _: 1 })]), _: 1 }), u(l, { key: "attachments", prop: "attachments", label: "附件", align: "center", width: "150", "show-overflow-tooltip": true }, { header: o(() => [u(se, { effect: "light", content: "双击可预览附件", placement: "top" }, { default: o(() => [m("div", null, [n[2] || (n[2] = m("span", null, "附件", -1)), u(ue, null, { default: o(() => [u(re)]), _: 1 })])]), _: 1 })]), default: o((e) => [e.row.isModify ? (s(), d(i(Qe), { key: 0, ref: "uploadRef", files: e.row.files, "onUpdate:files": (r) => e.row.files = r, "file-classify": i(Be).CONTRACT_ATT.V, limit: 1, accept: ".pdf,.jpg,.jpeg,.png" }, null, 8, ["files", "onUpdate:files", "file-classify"])) : v("", true), e.row.attachments && e.row.attachments.length > 0 && !e.row.files ? (s(true), y(O, { key: 1 }, ge(e.row.attachments, (r) => (s(), y("div", { key: r.id }, [m("div", { style: { cursor: "pointer" }, onDblclick: (at) => ae(r) }, p(r.name), 41, Le)]))), 128)) : v("", true)]), _: 1 }), u(l, { key: "invoiceType", prop: "invoiceType", label: "发票类型", align: "center", width: "120" }, { default: o((e) => [m("div", null, p(e.row.invoiceType ? i(P).VL[e.row.invoiceType] : ""), 1)]), _: 1 }), u(l, { key: "taxRate", prop: "taxRate", label: "税率", align: "center", width: "150" }, { default: o((e) => [e.row.invoiceType !== i(P).RECEIPT.V && e.row.isModify ? (s(), y("div", Ye, [m("div", We, [m("div", Xe, [u(ce, { modelValue: e.row.checked, "onUpdate:modelValue": (r) => e.row.checked = r, label: "免税", size: "large", onChange: (r) => X(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), u(j, { modelValue: e.row.taxRate, "onUpdate:modelValue": (r) => e.row.taxRate = r, step: 1, min: 0, max: 100, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "100px", "text-align": "center" }, placeholder: "0-100", disabled: e.row.checked, onChange: (r) => U(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"]), n[3] || (n[3] = m("span", { style: { "line-height": "40px" } }, "%", -1))])])) : (s(), y("div", Ze, p(e.row.checked && e.row.invoiceType ? "免税" : i(T)(e.row.taxRate) ? e.row.taxRate + "%" : "-"), 1))]), _: 1 }), u(l, { key: "branchCompanyId", prop: "branchCompanyId", label: "购方单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: o((e) => [m("div", null, p(e.row.branchCompanyName), 1)]), _: 1 }), u(l, { key: "supplierId", prop: "supplierId", label: "销售单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: o((e) => [m("div", null, p(e.row.supplierName), 1)]), _: 1 }), u(l, { prop: "invoiceSerialNumber", label: "发票号码", align: "center", "min-width": "150" }, { default: o((e) => [e.row.isModify ? (s(), d(de, { key: 0, modelValue: e.row.invoiceSerialNumber, "onUpdate:modelValue": (r) => e.row.invoiceSerialNumber = r, modelModifiers: { trim: true }, type: "text", placeholder: "发票号码", style: { width: "100%" }, maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (s(), y("span", et, p(e.row.invoiceSerialNumber), 1))]), _: 1 }), u(l, { key: "applyUserName", prop: "applyUserName", label: "办理人", align: "center", width: "100px" }, { default: o((e) => [m("div", null, p(e.row.applyUserName), 1)]), _: 1 }), u(l, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center", width: "100px" }, { default: o((e) => [m("div", null, p(e.row.auditUserName), 1)]), _: 1 }), i(N)([...i(h).edit, ...i(h).audit]) ? (s(), d(l, { key: 0, label: "操作", width: "190px", align: "center" }, { default: o((e) => [e.row.isModify ? (s(), y(O, { key: 1 }, [u(D, { "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定取消吗?", onConfirm: (r) => ne(e.row, e.$index) }, { reference: o(() => [u(a, { type: "primary", size: "default" }, { default: o(() => n[6] || (n[6] = [w("取消")])), _: 1, __: [6] })]), _: 2 }, 1032, ["onConfirm"]), u(a, { type: "info", plain: "", size: "default", onClick: (r) => ie(e.row) }, { default: o(() => n[7] || (n[7] = [w("保存")])), _: 2, __: [7] }, 1032, ["onClick"])], 64)) : (s(), y(O, { key: 0 }, [e.row.auditStatus === i(C).AUDITING.V && i(N)(i(h).edit) ? (s(), d(a, { key: 0, icon: "el-icon-edit", type: "primary", size: "default", onClick: (r) => ee(e.row) }, null, 8, ["onClick"])) : v("", true), e.row.auditStatus === i(C).AUDITING.V && i(N)(i(h).del) ? (s(), d(D, { key: 1, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定删除吗?", onConfirm: (r) => te(e.row) }, { reference: o(() => [u(a, { icon: "el-icon-delete", type: "danger", size: "default" })]), _: 2 }, 1032, ["onConfirm"])) : v("", true), e.row.auditStatus === i(C).AUDITING.V && i(N)(i(h).audit) ? (s(), d(D, { key: 2, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定通过吗?", onConfirm: (r) => Z(e.row) }, { reference: o(() => [u(a, { type: "success", size: "default" }, { default: o(() => n[4] || (n[4] = [w("通过")])), _: 1, __: [4] })]), _: 2 }, 1032, ["onConfirm"])) : v("", true), e.row.auditStatus === i(C).PASS.V ? (s(), d(f, { key: 3, type: "success", class: "pass-tag" }, { default: o(() => n[5] || (n[5] = [w("已复核")])), _: 1, __: [5] })) : v("", true)], 64))]), _: 1 })) : v("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[ye, i(c).loading]]), u(i(ze)), u(i(He), { existInvoiceNo: V.value, currentRow: _.currentRow, propertyType: _.propertyType }, null, 8, ["existInvoiceNo", "currentRow", "propertyType"]), I.value ? (s(), d(Fe, { key: 0, isVisible: I.value, showType: "attachment", id: z.value, onClose: n[0] || (n[0] = (e) => I.value = false) }, null, 8, ["isVisible", "id"])) : v("", true)]);
  };
} }, dt = Ue(tt, [["__scopeId", "data-v-11bce50d"]]);
export {
  dt as default
};
