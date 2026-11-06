import { ref as y } from "vue";
import { watch as re } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as ue } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as A } from "vue";
import { withDirectives as w } from "vue";
import { vShow as Q } from "vue";
import { unref as e } from "vue";
import { createElementVNode as B } from "vue";
import { createVNode as l } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as N } from "vue";
import { Fragment as Y } from "vue";
import { renderList as ie } from "vue";
import { createBlock as C } from "vue";
import { toDisplayString as de } from "vue";
import { createCommentVNode as E } from "vue";
import { ElDatePicker as me } from "element-plus";
import { ElRadioButton as ce } from "element-plus";
import { ElRadioGroup as pe } from "element-plus";
import { ElCol as fe } from "element-plus";
import { ElRow as ye } from "element-plus";
import { ElInput as _e } from "element-plus";
import { ElBadge as ge } from "element-plus";
import { vLoading as ve } from "element-plus";
import { _ as Ve, m as be, g8 as Ce, c1 as I, iF as z, B as Ee, jt as q, bN as R, K as g, kl as he, km as Se, kn as we, G as T, gD as Ne, iH as Te, C as xe, ko as Ue, L as ke, kp as je, E as De } from "../../../../shared/runtime.js";
import { _ as Le } from "../../../../modules/ExcelUploadBtn-acccae97.js";
import { P as _ } from "../../../../modules/index-5b9e6004.js";
import Ae from "./complete-list/index.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/contract-9b18cc88.js";
import "../../info/index.vue.js";
import "../../info/zn-base.vue.js";
import "../../info/customer.vue.js";
import "../../../../modules/region-cascader-39b54da2.js";
import "../../info/members.vue.js";
import "../../info/money-form.vue.js";
import "../../info/components/user-dept-cascader.vue.js";
import "../../../../modules/UploadBtn-b4cfb47a.js";
import "../../info/settle-form.vue.js";
import "../../info/variation-order.vue.js";
const Be = { __name: "header", emits: ["projectChange", "contentChange", "totalAmountChang"], setup(Ie, { emit: G }) {
  const { flag: O } = be(["flag"]), F = Ce(["structure_status"]), x = y([]), U = y([]), v = y([]), V = y(false), H = { projectType: void 0, year: void 0, noOrProjectName: void 0, businessType: void 0, projectContentId: void 0, signerName: "", customerUnit: void 0, address: void 0, status: I.PROCESS.V, settlementStatus: z.UNSETTLEMENT.V, contractSignBodyId: void 0 }, k = y(), c = y({}), j = y(false), D = G, { crud: d, query: o, CRUD: $ } = Ee(H);
  K(), P();
  async function K() {
    var n, t, h;
    try {
      x.value = await q({ businessType: R.MACHINING.V, flag: O.value }), U.value = await q({ businessType: R.INSTALLATION.V, flag: O.value });
      const r = [x.value, U.value];
      for (let i = 0; i < r.length; i++) r[i] && ((n = r[i][g.STEEL.V]) == null ? void 0 : n.length) > 0 && r[i][g.STEEL.V].map((m) => {
        m.name = m.categoryName;
      }), r[i] && ((t = r[i][g.BRIDGE.V]) == null ? void 0 : t.length) > 0 && r[i][g.BRIDGE.V].map((m) => {
        m.name = m.categoryName;
      }), r[i] && ((h = r[i][g.ENCLOSURE.V]) == null ? void 0 : h.length) > 0 && r[i][g.ENCLOSURE.V].map((m) => {
        m.name = m.categoryName;
      });
      D("contentChange", x.value, U.value);
    } catch (r) {
      console.log(r);
    }
  }
  function J() {
    u();
  }
  function W() {
    V.value = false, u(), D("projectChange");
  }
  X();
  async function X() {
    try {
      const n = await he();
      k.value = n.outFinishCount || 0;
    } catch (n) {
      console.log("获取完工列表", n);
    }
  }
  re(() => o.year, (n) => {
    M();
  }, { immediate: true }), $.HOOK.handleRefresh = () => {
    M();
  };
  async function M() {
    try {
      j.value = true;
      const n = await Se({ year: o.year });
      c.value = n || {};
    } catch (n) {
      console.log("获取项目数量", n);
    } finally {
      j.value = false;
    }
  }
  function Z() {
    d.query.settlementStatus === z.SETTLED.V && (d.query.status = void 0), u();
  }
  async function P() {
    try {
      const n = await we(d.query);
      console.log(n, "response"), v.value[0] = "合计", v.value[9] = n;
    } catch (n) {
      console.error("获取汇总失败:", n), v.value[0] = "合计", v.value[9] = "-";
    } finally {
      D("totalAmountChang", v.value);
    }
  }
  function u() {
    d.toQuery(), P();
  }
  return (n, t) => {
    const h = me, r = ce, i = pe, m = b("common-radio-button"), f = fe, ee = ye, L = b("common-select"), S = _e, te = b("common-button"), le = ge, ae = b("print-table"), oe = b("common-drawer"), ne = ve, se = ue("permission");
    return p(), A("div", null, [w(B("div", null, [l(h, { modelValue: e(o).year, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).year = a), class: "date-item filter-item", format: "YYYY", placeholder: "选择年", size: "small", style: { width: "100px !important" }, type: "year", "value-format": "YYYY", onChange: u }, null, 8, ["modelValue"]), l(i, { modelValue: e(o).status, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).status = a), class: "filter-item", size: "default", onChange: u }, { default: s(() => [l(r, { label: void 0 }, { default: s(() => t[13] || (t[13] = [N("全部")])), _: 1, __: [13] }), (p(true), A(Y, null, ie(e(I).ENUM, (a) => (p(), A(Y, null, [a.V != e(I).SETTLED.V ? (p(), C(r, { key: a.V, label: a.V }, { default: s(() => [N(de(a.L), 1)]), _: 2 }, 1032, ["label"])) : E("", true)], 64))), 256))]), _: 1 }, 8, ["modelValue"]), l(m, { modelValue: e(o).settlementStatus, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).settlementStatus = a), optionAllValue: void 0, options: e(z).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: Z }, null, 8, ["modelValue", "options"])], 512), [[Q, e(d).searchToggle]]), e(T)(e(d).permission.get) ? w((p(), C(ee, { key: 0, gutter: 20, class: "panel-group" }, { default: s(() => [l(f, { span: 4, class: "card-panel-col" }, { default: s(() => [l(e(_), { "end-val": c.value.sumQuantity || 0, precision: 0, name: "项目总数", "num-color": "#FCC90B", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), l(f, { span: 4, class: "card-panel-col" }, { default: s(() => [l(e(_), { "end-val": c.value.selfSupportQuantity || 0, precision: 0, name: "自营项目", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), l(f, { span: 4, class: "card-panel-col" }, { default: s(() => [l(e(_), { "end-val": c.value.jointVentureQuantity || 0, precision: 0, name: "合营项目", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), l(f, { span: 3, class: "card-panel-col" }, { default: s(() => [l(e(_), { "end-val": c.value.lumpSumSystemQuantity || 0, precision: 0, name: "内包制项目", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), l(f, { span: 3, class: "card-panel-col" }, { default: s(() => [l(e(_), { "end-val": c.value.processingQuantity || 0, precision: 0, name: "进行中", "num-color": "#67C23A", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), l(f, { span: 3, class: "card-panel-col" }, { default: s(() => [l(e(_), { "end-val": c.value.completedQuantity || 0, precision: 0, name: "已完工", "num-color": "#67C23A", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 }), l(f, { span: 3, class: "card-panel-col" }, { default: s(() => [l(e(_), { "end-val": c.value.settlementQuantity || 0, precision: 0, name: "已结算", "num-color": "#67C23A", "text-color": "#626262" }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[ne, j.value]]) : E("", true), w(B("div", null, [l(L, { modelValue: e(o).businessType, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(o).businessType = a), options: e(R).ENUM, type: "enum", size: "default", clearable: "", style: { width: "200px" }, class: "filter-item", placeholder: "订单类型", onChange: J }, null, 8, ["modelValue", "options"]), l(L, { modelValue: e(o).projectAttribute, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(o).projectAttribute = a), options: e(Ne).ENUM, class: "filter-item", clearable: "", placeholder: "经营方式", size: "small", style: { width: "200px" }, type: "enum", onChange: u }, null, 8, ["modelValue", "options"]), l(L, { size: "default", modelValue: e(o).structureStatus, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(o).structureStatus = a), "data-structure": { key: "id", label: "label", value: "id" }, options: e(F).structure_status, class: "filter-item", clearable: "", placeholder: "结构类型", style: { width: "200px" }, type: "other", onChange: u }, null, 8, ["modelValue", "options"]), l(Te, { modelValue: e(o).contractSignBodyId, "onUpdate:modelValue": t[6] || (t[6] = (a) => e(o).contractSignBodyId = a), class: "filter-item", clearable: "", placeholder: "合同签订主体", style: { width: "200px" }, onChange: u }, null, 8, ["modelValue"]), l(S, { modelValue: e(o).noOrProjectName, "onUpdate:modelValue": t[7] || (t[7] = (a) => e(o).noOrProjectName = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "输入合同编号或项目简称", size: "default", style: { width: "200px" }, onBlur: u }, null, 8, ["modelValue"]), l(S, { modelValue: e(o).signerName, "onUpdate:modelValue": t[8] || (t[8] = (a) => e(o).signerName = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "销售负责人", size: "default", style: { width: "180px" }, onBlur: u }, null, 8, ["modelValue"]), B("div", null, [l(S, { modelValue: e(o).customerUnit, "onUpdate:modelValue": t[9] || (t[9] = (a) => e(o).customerUnit = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "客户名称", size: "default", style: { width: "180px" }, onBlur: u }, null, 8, ["modelValue"]), l(S, { modelValue: e(o).address, "onUpdate:modelValue": t[10] || (t[10] = (a) => e(o).address = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "项目地点", maxlength: "15", size: "default", style: { width: "180px" }, onBlur: u }, null, 8, ["modelValue"]), l(e(xe))]), l(e(De), { "add-text": "合同立项" }, { optRight: s(() => [e(T)(e(d).permission.completeList.get) ? (p(), C(le, { key: 0, hidden: k.value < 1, max: 99, value: k.value }, { default: s(() => [l(te, { class: "filter-item", size: "mini", type: "primary", onClick: t[11] || (t[11] = (a) => V.value = true) }, { default: s(() => t[14] || (t[14] = [N("可完工项目 ")])), _: 1, __: [14] })]), _: 1 }, 8, ["hidden", "value"])) : E("", true), e(T)(e(d).permission.listImport) ? (p(), C(e(Le), { key: 1, "upload-fun": e(Ue), "btn-name": "清单导入", "btn-type": "success", "btn-size": "default", class: "filter-item", onSuccess: u }, null, 8, ["upload-fun"])) : E("", true), e(T)(e(d).permission.listTemplate) ? (p(), C(ke, { key: 2, fn: e(je), class: "filter-item" }, { default: s(() => t[15] || (t[15] = [N(" 清单模版下载 ")])), _: 1, __: [15] }, 8, ["fn"])) : E("", true)]), viewLeft: s(() => [w(l(ae, { params: { year: e(d).query.year }, "api-key": "projectList", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"]), [[se, e(d).permission.print]])]), _: 1 })], 512), [[Q, e(d).searchToggle]]), l(oe, { modelValue: V.value, "onUpdate:modelValue": t[12] || (t[12] = (a) => V.value = a), "append-to-body": true, "before-close": () => {
      V.value = false;
    }, "close-on-click-modal": false, "show-close": true, direction: "rtl", size: "80%", title: "可完工项目" }, { content: s(() => [l(e(Ae), { onSuccess: W })]), _: 1 }, 8, ["modelValue", "before-close"])]);
  };
} }, lt = Ve(Be, [["__scopeId", "data-v-ed4431fd"]]);
export {
  lt as default
};
