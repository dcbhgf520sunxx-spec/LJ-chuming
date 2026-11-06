import { ref as A } from "vue";
import { provide as K } from "vue";
import { watch as Y } from "vue";
import { resolveComponent as O } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as y } from "vue";
import { withDirectives as P } from "vue";
import { unref as n } from "vue";
import { createBlock as p } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as T } from "vue";
import { createVNode as a } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as N } from "vue";
import { Fragment as X } from "vue";
import { nextTick as we } from "vue";
import { ElMessage as Z } from "element-plus";
import { ElTag as xe } from "element-plus";
import { ElTableColumn as ke } from "element-plus";
import { ElDatePicker as be } from "element-plus";
import { ElInputNumber as Ae } from "element-plus";
import { ElCheckbox as Ce } from "element-plus";
import { ElInput as Ve } from "element-plus";
import { ElPopconfirm as Ie } from "element-plus";
import { vLoading as Te } from "element-plus";
import { l as U, _ as Ne, t as Re, x as Se, c3 as C, o as Ue, bD as V, bV as F, p as Ee, i as R, ia as De, G as q, P as Me, fK as ee } from "../../../../../../shared/runtime.js";
import { V as Oe } from "../../../../../../modules/contract-9b18cc88.js";
import Pe from "./form.vue.js";
function qe(s) {
  return U({ module: "contract", url: "contract/invoice/waste", method: "get", params: s });
}
function Be(s) {
  return U({ module: "contract", url: "contract/invoice/waste", method: "post", params: { projectId: s.projectId }, data: s.list });
}
function je(s) {
  return U({ module: "contract", url: "contract/invoice/waste", method: "put", data: s });
}
function ze(s) {
  return U({ module: "contract", url: `contract/invoice/deleteById/${s}/waste`, method: "delete" });
}
function $e(s) {
  return U({ module: "contract", url: "contract/invoice/audit/waste", method: "put", data: s });
}
const B = { get: qe, add: Be, edit: je, del: ze };
const Fe = { class: "app-container" }, Qe = { class: "clearfix" }, Ge = { style: { float: "left" } }, He = { style: { float: "right" } }, Je = { key: 1 }, Le = { key: 1 }, Ke = { key: 0 }, Ye = { style: { display: "flex" } }, We = { style: { "padding-right": "5px" } }, Xe = { key: 1 }, Ze = { key: 1 }, et = { key: 1 }, tt = { key: 1 }, ot = { key: 1 }, nt = { __name: "index", props: { currentRow: { type: Object, default: () => {
} }, moneySum: { type: Object, default: () => {
} }, projectId: { type: [String, Number], default: void 0 }, visibleValue: { type: Boolean, default: false } }, emits: ["success"], setup(s, { emit: te }) {
  const { decimalPrecision: x } = Re(), k = Oe.invoice, oe = { add: true, edit: false, del: false, download: false }, w = s, Q = A(), j = A({}), G = A({}), ne = A([]), h = A(0), z = A([]), ie = te;
  K("contractInfo", j), K("totalAmount", h);
  const { crud: u, CRUD: S } = Se({ title: "开票填报", sort: [], permission: { ...k }, optShow: { ...oe }, crudApi: { ...B }, invisibleColumns: ["haveInvoiceAmount", "collectionMode", "invoiceType", "collectionDepositBank", "collectionBankAccount", "paymentBankAccount", "paymentDepositBank", "auditorName", "auditTime"], hasPagination: true, params: {} }, Q), H = { invoiceDate: [{ required: true, message: "请选择开票日期", trigger: "change" }], invoiceAmount: [{ required: true, message: "请选择开票额", trigger: "change", type: "number" }], taxRate: [{ validator: (t, o) => o.invoiceType !== V.RECEIPT.V && !o.checked ? R(t) : true, message: "请输入税率", trigger: "blur" }], invoiceType: [{ required: true, message: "请选择发票类型", trigger: "change" }], invoiceNo: [{ required: true, message: "请输入发票号", trigger: "blur" }], collectionUnit: [{ required: true, message: "请输入收票单位", trigger: "blur" }] }, J = { invoiceDate: [{ required: true, message: "请选择开票日期", trigger: "change" }], invoiceAmount: [{ required: true, message: "请选择开票额", trigger: "change", type: "number" }], invoiceNo: [{ required: true, message: "请输入发票号", trigger: "blur" }], collectionUnit: [{ required: true, message: "请输入收票单位", trigger: "blur" }] }, ae = A([C.AUDITING, C.PASS]);
  function le({ row: t, column: o }) {
    if (!t) return;
    let i = {};
    t.invoiceType !== V.RECEIPT.V ? i = H : i = J;
    let m = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[o.property] === false && (m = ee(o.property, i[o.property], t)), m && (t.verify[o.property] = true)), m ? "" : "mask-td";
  }
  const { maxHeight: re } = Ue({ wrapperBox: ".collection", paginate: true, extraHeight: 40 });
  Y(() => w.currentRow, (t) => {
    console.log(t), ne.value = [], j.value = {}, t && ue(t.branchCompanyId), u.toQuery();
  }, { deep: true, immediate: true }), Y(() => w.visibleValue, (t) => {
    t && u.toQuery();
  }, { deep: true, immediate: true });
  async function ue(t) {
    try {
    } catch (o) {
      console.log("获取合同信息", o);
    } finally {
      j.value = w.currentRow;
    }
  }
  function ce(t) {
    if (w.currentRow.settlementAmount && (h.value = 0, u.data.map((o) => {
      o.invoiceAmount && (h.value += o.invoiceAmount);
    }), h.value > w.currentRow.settlementAmount)) {
      const o = t.invoiceAmount - (h.value - w.currentRow.settlementAmount);
      we(() => {
        t.invoiceAmount = o || 0, E(t), h.value = 0, u.data.map((i) => {
          i.invoiceAmount && (h.value += i.invoiceAmount);
        });
      });
    }
    E(t);
  }
  function de(t) {
    t.boolIncludeTax = !t.checked, t.taxRate = t.checked ? 0 : t.originRate, E(t);
  }
  function E(t) {
    t.tax = 0;
    let o = t.invoiceAmount;
    R(t.invoiceAmount) && t.taxRate ? (t.tax = t.invoiceAmount * t.taxRate / 100, o = (t.invoiceAmount / (1 + t.taxRate / 100)).toFixed(x.value.contract)) : t.invoiceType === V.RECEIPT.V && (o = t.invoiceAmount), t.noTaxAmount = o;
  }
  async function se(t) {
    try {
      await $e({ id: t.id, auditStatus: C.PASS.V }), u.notify("审核成功", S.NOTIFICATION_TYPE.SUCCESS), u.toQuery(), ie("success");
    } catch (o) {
      console.log("审核失败", o);
    }
  }
  function me(t) {
    G.value = JSON.parse(JSON.stringify(t)), t.isModify = true;
  }
  async function pe(t) {
    try {
      await B.del(t.id), u.notify("删除成功", S.NOTIFICATION_TYPE.SUCCESS), u.toQuery();
    } catch (o) {
      console.log("删除失败", o);
    }
  }
  function fe(t) {
    if (t.isModify = false, t.id) t = Object.assign(t, JSON.parse(JSON.stringify(G.value)));
    else {
      const o = u.data.findIndex((i) => i.dataIndex === t.dataIndex);
      u.data.splice(o, 1);
    }
  }
  async function ye(t) {
    if (t.invoiceAmount === 0) {
      Z.error("开票额必须大于0");
      return;
    }
    let o = {};
    t.invoiceType !== V.RECEIPT.V ? o = H : o = J;
    let i = true;
    t.verify = {};
    for (const v in o) t.verify[v] = ee(v, o[v], t), t.verify[v] || (i = false);
    if (!i) {
      Z.error("请填写表格中标红数据");
      return;
    }
    const m = t.id ? "修改" : "新增";
    try {
      t.id ? await B.edit(t) : await B.add(t), u.notify(`${m}成功`, S.NOTIFICATION_TYPE.SUCCESS), u.toQuery();
    } catch (v) {
      console.log(m, v);
    }
  }
  function ve(t) {
    const { columns: o, data: i } = t, m = [];
    return o.forEach((v, b) => {
      var d;
      if (b === 0) {
        m[b] = "查询合计";
        return;
      }
      if (v.property === "invoiceAmount") {
        const D = i.map((_) => _.invoiceAmount);
        D.every((_) => isNaN(_)) || (m[b] = D.reduce((_, M) => {
          const I = Number(M);
          return isNaN(I) ? _ : _ + M;
        }, 0)), m[b] = (d = m[b]) == null ? void 0 : d.toFixed(x.value.contract);
      }
    }), m;
  }
  return S.HOOK.beforeRefresh = () => {
    u.query.branchCompanyId = w.currentRow.branchCompanyId, u.query.contractWasteId = w.currentRow.contractWasteId;
  }, S.HOOK.handleRefresh = (t, o) => {
    h.value = 0, z.value = [], o.data.content.map((i) => {
      i.dataIndex = i.id + "id", i.invoiceAmount && (h.value += i.invoiceAmount), i.invoiceNo && z.value.push({ invoiceNo: i.invoiceNo, dataIndex: i.dataIndex }), i.checked = !i.boolIncludeTax, i.noTaxAmount = i.invoiceType !== V.RECEIPT.V ? (i.invoiceAmount / (1 + i.taxRate / 100)).toFixed(x.value.contract) : i.invoiceAmount, i.originRate = i.taxRate;
    });
  }, (t, o) => {
    const i = O("common-button"), m = O("common-radio-button"), v = xe, b = O("print-table"), d = ke, D = be, _ = Ae, M = Ce, I = Ve, $ = Ie, ge = O("common-table"), L = W("permission"), he = W("show-thousand"), _e = Te;
    return l(), g("div", Fe, [y("div", Qe, [y("div", Ge, [P((l(), p(i, { type: "primary", size: "default", onClick: n(u).toAdd, style: { "margin-right": "10px" } }, { default: r(() => o[1] || (o[1] = [T(" 添加 ")])), _: 1, __: [1] }, 8, ["onClick"])), [[L, n(k).add]]), a(m, { modelValue: n(u).query.auditStatus, "onUpdate:modelValue": o[0] || (o[0] = (e) => n(u).query.auditStatus = e), options: ae.value, showOptionAll: "", size: "default", style: { float: "right" }, type: "enum", onChange: n(u).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), y("div", He, [s.moneySum.invoiceAmount ? (l(), p(v, { key: 0, type: "warning", size: "large", style: { "margin-left": "5px" } }, { default: r(() => [T(" 已开票【审核通过】：" + f(n(F)(s.moneySum.invoiceAmount, n(x).contract)), 1)]), _: 1 })) : N("", true), P(a(b, { "api-key": "scrapInvoice", params: n(u).query, style: { "margin-left": "5px", float: "right" }, size: "default", type: "warning" }, null, 8, ["params"]), [[L, n(u).permission.print]])])]), P((l(), p(ge, { ref_key: "tableRef", ref: Q, data: n(u).data, "empty-text": n(u).emptyText, "max-height": n(re), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", "cell-class-name": le, stripe: false, "return-source-data": "", "show-summary": "", "summary-method": ve, showEmptySymbol: false }, { default: r(() => [a(d, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), a(d, { key: "invoiceDate", prop: "invoiceDate", label: "开票日期", align: "center", width: "125" }, { default: r((e) => [e.row.isModify ? (l(), p(D, { key: 0, modelValue: e.row.invoiceDate, "onUpdate:modelValue": (c) => e.row.invoiceDate = c, type: "date", size: "default", "value-format": "x", placeholder: "选择日期", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (l(), g("div", Je, f(e.row.invoiceDate ? n(Ee)(e.row.invoiceDate, "{y}-{m}-{d}") : "-"), 1))]), _: 1 }), a(d, { key: "invoiceAmount2", prop: "invoiceAmount2", label: "开票额", align: "center", "min-width": "220", class: "money-column" }, { default: r(() => [a(d, { key: "invoiceAmount", prop: "invoiceAmount", label: "金额", align: "center", "min-width": "110" }, { default: r((e) => [e.row.isModify ? P((l(), p(_, { key: 0, modelValue: e.row.invoiceAmount, "onUpdate:modelValue": (c) => e.row.invoiceAmount = c, modelModifiers: { number: true }, min: -9999999999, max: 9999999999, step: 100, precision: n(x).contract, placeholder: "开票额(元)", "controls-position": "right", onChange: (c) => ce(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])), [[he]]) : (l(), g("div", Le, f(n(R)(e.row.invoiceAmount) ? n(F)(e.row.invoiceAmount, n(x).contract) : "-"), 1))]), _: 1 }), a(d, { key: "invoiceAmount1", prop: "invoiceAmount1", label: "大写", align: "center", "min-width": "110", "show-overflow-tooltip": true }, { default: r((e) => [y("div", null, f(n(R)(e.row.invoiceAmount) ? n(De)(e.row.invoiceAmount) : "-"), 1)]), _: 1 })]), _: 1 }), a(d, { key: "invoiceType", prop: "invoiceType", label: "发票类型", align: "center", width: "110" }, { default: r((e) => [y("div", null, f(e.row.invoiceType ? n(V).VL[e.row.invoiceType] : "-"), 1)]), _: 1 }), a(d, { key: "taxRate", prop: "taxRate", label: "税率", align: "center", width: "130" }, { default: r((e) => [e.row.invoiceType !== n(V).RECEIPT.V && e.row.isModify ? (l(), g("div", Ke, [y("div", Ye, [y("div", We, [a(M, { modelValue: e.row.checked, "onUpdate:modelValue": (c) => e.row.checked = c, label: "免税", size: "large", onChange: (c) => de(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), a(_, { modelValue: e.row.taxRate, "onUpdate:modelValue": (c) => e.row.taxRate = c, step: 1, min: 0, max: 100, precision: 0, controls: false, "controls-position": "right", class: "input-underline", style: { width: "80px", "text-align": "center" }, placeholder: "0-100", disabled: e.row.checked, onChange: (c) => E(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"]), o[2] || (o[2] = y("span", { style: { "line-height": "40px" } }, "%", -1))])])) : (l(), g("div", Xe, f(e.row.checked && e.row.invoiceType ? "免税" : n(R)(e.row.taxRate) ? e.row.taxRate + "%" : "-"), 1))]), _: 1 }), a(d, { key: "noTaxAmount", prop: "noTaxAmount", label: "不含税金额", align: "center", width: "70" }, { default: r((e) => [y("span", null, f(n(R)(e.row.noTaxAmount) ? n(F)(e.row.noTaxAmount, n(x).contract) : "-"), 1)]), _: 1 }), a(d, { key: "invoiceUnit", prop: "invoiceUnit", label: "开票单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: r((e) => [y("div", null, f(e.row.invoiceUnit), 1)]), _: 1 }), a(d, { key: "collectionUnit", prop: "collectionUnit", label: "收票单位", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: r((e) => [e.row.isModify ? (l(), p(I, { key: 0, modelValue: e.row.collectionUnit, "onUpdate:modelValue": (c) => e.row.collectionUnit = c, modelModifiers: { trim: true }, placeholder: "收票单位", style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (l(), g("div", Ze, f(e.row.collectionUnit), 1))]), _: 1 }), a(d, { prop: "invoiceNo", label: "发票号码", align: "center", "min-width": "130" }, { default: r((e) => [e.row.isModify ? (l(), p(I, { key: 0, modelValue: e.row.invoiceNo, "onUpdate:modelValue": (c) => e.row.invoiceNo = c, modelModifiers: { trim: true }, type: "text", placeholder: "发票号码", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (l(), g("span", et, f(e.row.invoiceNo), 1))]), _: 1 }), a(d, { prop: "invoiceContent", label: "发票内容", align: "center", "min-width": "130" }, { default: r((e) => [e.row.isModify ? (l(), p(I, { key: 0, modelValue: e.row.invoiceContent, "onUpdate:modelValue": (c) => e.row.invoiceContent = c, modelModifiers: { trim: true }, type: "text", placeholder: "发票内容", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (l(), g("span", tt, f(e.row.invoiceContent), 1))]), _: 1 }), a(d, { prop: "remark", label: "备注", align: "center", "min-width": "100" }, { default: r((e) => [e.row.isModify ? (l(), p(I, { key: 0, modelValue: e.row.remark, "onUpdate:modelValue": (c) => e.row.remark = c, modelModifiers: { trim: true }, type: "textarea", placeholder: "备注", style: { width: "100%" }, maxlength: "200" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (l(), g("span", ot, f(e.row.remark), 1))]), _: 1 }), a(d, { key: "writtenByName", prop: "writtenByName", label: "办理人", align: "center", width: "80px" }, { default: r((e) => [y("div", null, f(e.row.writtenByName), 1)]), _: 1 }), a(d, { key: "auditorName", prop: "auditorName", label: "审核人", align: "center", width: "80px" }, { default: r((e) => [y("div", null, f(e.row.auditorName), 1)]), _: 1 }), n(q)([...n(k).edit, ...n(k).audit]) ? (l(), p(d, { key: 0, label: "操作", width: "190px", align: "center" }, { default: r((e) => [e.row.isModify ? (l(), g(X, { key: 1 }, [a($, { "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定取消吗?", onConfirm: (c) => fe(e.row, e.$index) }, { reference: r(() => [a(i, { type: "primary", size: "default" }, { default: r(() => o[5] || (o[5] = [T("取消")])), _: 1, __: [5] })]), _: 2 }, 1032, ["onConfirm"]), a(i, { type: "info", plain: "", size: "default", onClick: (c) => ye(e.row) }, { default: r(() => o[6] || (o[6] = [T("保存")])), _: 2, __: [6] }, 1032, ["onClick"])], 64)) : (l(), g(X, { key: 0 }, [e.row.auditStatus === n(C).AUDITING.V && n(q)(n(k).edit) ? (l(), p(i, { key: 0, icon: "el-icon-edit", type: "primary", size: "default", onClick: (c) => me(e.row) }, null, 8, ["onClick"])) : N("", true), e.row.auditStatus === n(C).AUDITING.V && n(q)(n(k).del) ? (l(), p($, { key: 1, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定删除吗?", onConfirm: (c) => pe(e.row) }, { reference: r(() => [a(i, { icon: "el-icon-delete", type: "danger", size: "default" })]), _: 2 }, 1032, ["onConfirm"])) : N("", true), e.row.auditStatus === n(C).AUDITING.V && n(q)(n(k).audit) ? (l(), p($, { key: 2, "confirm-button-text": "确定", "cancel-button-text": "取消", title: "确定通过吗?", onConfirm: (c) => se(e.row) }, { reference: r(() => [a(i, { type: "success", size: "default" }, { default: r(() => o[3] || (o[3] = [T("通过")])), _: 1, __: [3] })]), _: 2 }, 1032, ["onConfirm"])) : N("", true), e.row.auditStatus === n(C).PASS.V ? (l(), p(v, { key: 3, type: "success", class: "pass-tag" }, { default: r(() => o[4] || (o[4] = [T("已复核")])), _: 1, __: [4] })) : N("", true)], 64))]), _: 1 })) : N("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[_e, n(u).loading]]), a(n(Me)), a(n(Pe), { existInvoiceNo: z.value, projectId: s.projectId, currentRow: s.currentRow }, null, 8, ["existInvoiceNo", "projectId", "currentRow"])]);
  };
} }, ct = Ne(nt, [["__scopeId", "data-v-e022afe8"]]);
export {
  ct as default
};
