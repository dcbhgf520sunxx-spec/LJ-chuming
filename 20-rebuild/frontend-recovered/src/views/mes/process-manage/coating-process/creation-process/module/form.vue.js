import { useStore as M } from "vuex";
import { ref as V } from "vue";
import O from "moment";
import { watch as Y } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as U } from "vue";
import { createBlock as h } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { createTextVNode as x } from "vue";
import { createElementVNode as n } from "vue";
import { createCommentVNode as q } from "vue";
import { toDisplayString as m } from "vue";
import { ElMessage as P } from "element-plus";
import { ElFormItem as $ } from "element-plus";
import { ElInput as G } from "element-plus";
import { ElDatePicker as H } from "element-plus";
import { ElForm as J } from "element-plus";
import { ElDescriptionsItem as K } from "element-plus";
import { ElDescriptions as Q } from "element-plus";
import { e as W, c as X } from "../../../../../../modules/creation-process-d3879d47.js";
import { _ as Z, m as ee, ao as ae, i as D, fv as te, q as le, cy as re, bY as oe, bV as F } from "../../../../../../shared/runtime.js";
const ne = { class: "form-row" }, se = { class: "input-underline" }, de = { class: "input-underline" }, ie = { class: "input-underline" }, ce = { class: "form-row" }, ue = { class: "input-underline" }, me = { class: "input-underline" }, fe = { __name: "form", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, calculateForm: { type: Object, default: () => {
} }, secondaryData: { type: Object, default: () => {
} } }, emits: ["submitSuccess"], setup(s, { emit: j }) {
  var v;
  const { user: C } = ee("user"), N = M(), T = j, i = s, E = V({ projectId: void 0, monomerIdList: void 0, createUserId: (v = C.value) == null ? void 0 : v.id, createdDate: O().startOf("day").valueOf(), serialNumber: void 0, remark: void 0 }), I = V(), { crud: y, form: l, CRUD: k } = ae(E, I), L = { projectId: [{ required: true, message: "请选择项目", trigger: "change" }], createUserId: [{ required: true, message: "请输入创建人", trigger: "blur" }], createdDate: [{ required: true, message: "请选择创建日期", trigger: "change" }] };
  function z(b) {
    return b > /* @__PURE__ */ new Date();
  }
  async function S() {
    var b, r, f, u, p;
    try {
      if (!await I.value.validate()) return;
      const g = { projectId: l.projectId, monomerIdList: l.monomerIdList, createDate: l.createdDate, createUserId: l.createUserId, id: ((b = i.secondaryData) == null ? void 0 : b.id) || void 0, surfaceArea: (r = i.calculateForm) == null ? void 0 : r.surfaceArea, paintFilmThickness: (f = i.calculateForm) == null ? void 0 : f.filmThickness, lossCoefficient: (u = i.calculateForm) == null ? void 0 : u.lossCoefficient, ...i.currentRow, unitPrice: (p = i.currentRow) == null ? void 0 : p.price, remark: l.remark };
      D(i.secondaryData) ? await W(g) : await X(g), P({ message: "发起审批成功！", type: "success" }), await N.dispatch("approval_list/fetchApprovalNum"), T("submitSuccess"), y.cancelCU();
    } catch (_) {
      console.log(_);
    }
  }
  return Y(() => y.status.cu, (b) => {
    var r, f, u, p, _, g, d;
    b > k.STATUS.NORMAL && D(i.secondaryData) && (l.projectId = (r = i.secondaryData) == null ? void 0 : r.projectId, l.monomerIdList = (f = i.secondaryData) == null ? void 0 : f.monomerIdList, l.createUserId = (p = (u = i.secondaryData) == null ? void 0 : u.createUser) == null ? void 0 : p.id, l.createdDate = (_ = i.secondaryData) == null ? void 0 : _.createTime, l.serialNumber = (g = i.secondaryData) == null ? void 0 : g.serialNumber, l.remark = (d = i.secondaryData) == null ? void 0 : d.remark);
  }, { deep: true, immediate: true }), (b, r) => {
    const f = R("common-button"), u = $, p = G, _ = H, g = J, d = K, A = Q, B = R("common-drawer");
    return U(), h(B, { "append-to-body": "", ref: "drawerRef", "close-on-click-modal": false, visible: t(y).status.cu > t(k).STATUS.NORMAL, title: "涂装工艺创建", "before-close": t(y).cancelCU, "show-close": false, size: "55%" }, { titleRight: o(() => [a(f, { type: "warning", size: "default", onClick: t(y).cancelCU }, { default: o(() => r[6] || (r[6] = [x("上一步")])), _: 1, __: [6] }, 8, ["onClick"]), a(f, { type: "success", size: "default", onClick: S }, { default: o(() => r[7] || (r[7] = [x("提交审批")])), _: 1, __: [7] })]), content: o(() => [a(g, { ref_key: "formRef", ref: I, model: t(l), rules: L, inline: "", size: "default", "label-position": "right", "label-width": "100px" }, { default: o(() => [n("div", ne, [a(u, { label: "选择项目：", prop: "projectId" }, { default: o(() => [n("div", se, [a(t(te), { modelValue: t(l).projectId, "onUpdate:modelValue": r[0] || (r[0] = (c) => t(l).projectId = c), style: { width: "280px" }, clearable: "", placeholder: "请选择项目", disabled: t(D)(s.secondaryData) }, null, 8, ["modelValue", "disabled"])])]), _: 1 }), a(u, { label: "选择单体：", prop: "monomerIdList" }, { default: o(() => [n("div", de, [a(t(le), { ref: "monomerRef", modelValue: t(l).monomerIdList, "onUpdate:modelValue": r[1] || (r[1] = (c) => t(l).monomerIdList = c), "project-id": t(l).projectId, default: "", clearable: "", multiple: "", "collapse-tags": "", placeholder: "全部单体", style: { width: "200px" } }, null, 8, ["modelValue", "project-id"])])]), _: 1 }), t(D)(s.secondaryData) ? (U(), h(u, { key: 0, label: "工艺编号：", prop: "serialNumber" }, { default: o(() => [n("div", ie, [a(p, { modelValue: t(l).serialNumber, "onUpdate:modelValue": r[2] || (r[2] = (c) => t(l).serialNumber = c), modelModifiers: { trim: true }, readonly: "", clearable: "", size: "default", style: { width: "196px" } }, null, 8, ["modelValue"])])]), _: 1 })) : q("", true)]), n("div", ce, [a(u, { label: "创建人：", prop: "createUserId" }, { default: o(() => [n("div", ue, [a(t(re), { modelValue: t(l).createUserId, "onUpdate:modelValue": r[3] || (r[3] = (c) => t(l).createUserId = c), "collapse-tags": false, filterable: "", "show-all-levels": "", placeholder: "选择创建人" }, null, 8, ["modelValue"])])]), _: 1 }), a(u, { label: "创建日期：", prop: "createdDate" }, { default: o(() => [n("div", me, [a(_, { modelValue: t(l).createdDate, "onUpdate:modelValue": r[4] || (r[4] = (c) => t(l).createdDate = c), type: "date", size: "default", class: "date-item filter-item", placeholder: "选择日期", format: "YYYY-MM-DD", "value-format": "x", "disabled-date": z, style: { width: "140px" } }, null, 8, ["modelValue"])])]), _: 1 })])]), _: 1 }, 8, ["model"]), a(A, { column: 3, size: "large", border: "" }, { default: o(() => {
      var c;
      return [a(d, { align: "center", label: "油漆类型" }, { default: o(() => [n("span", null, m(s.currentRow.paintingTypeEnum ? t(oe).VL[s.currentRow.paintingTypeEnum] : "-"), 1)]), _: 1 }), a(d, { align: "center", label: "材质" }, { default: o(() => {
        var e;
        return [n("span", null, m(((e = s.currentRow) == null ? void 0 : e.paintType) || "-"), 1)];
      }), _: 1 }), a(d, { align: "center", label: "品牌" }, { default: o(() => {
        var e;
        return [n("span", null, m(((e = s.currentRow) == null ? void 0 : e.paintBrand) || "-"), 1)];
      }), _: 1 }), a(d, { align: "center", label: "表面积（㎡）" }, { default: o(() => {
        var e;
        return [n("span", null, m(((e = s.calculateForm) == null ? void 0 : e.surfaceArea) || "-"), 1)];
      }), _: 1 }), a(d, { align: "center", label: "漆膜厚度（μm）" }, { default: o(() => {
        var e;
        return [n("span", null, m(((e = s.calculateForm) == null ? void 0 : e.filmThickness) || "-"), 1)];
      }), _: 1 }), a(d, { align: "center", label: "损耗系数" }, { default: o(() => {
        var e;
        return [n("span", null, m(((e = s.calculateForm) == null ? void 0 : e.lossCoefficient) || "-"), 1)];
      }), _: 1 }), a(d, { align: "center", label: `数量（${(c = s.currentRow) == null ? void 0 : c.packageUnit}）` }, { default: o(() => {
        var e, w;
        return [n("span", null, m(((w = (e = s.currentRow) == null ? void 0 : e.quantity) == null ? void 0 : w.toFixed(2)) || "-"), 1)];
      }), _: 1 }, 8, ["label"]), a(d, { align: "center", label: "重量（kg）" }, { default: o(() => {
        var e, w;
        return [n("span", null, m(((w = (e = s.currentRow) == null ? void 0 : e.weight) == null ? void 0 : w.toFixed(2)) || "-"), 1)];
      }), _: 1 }), a(d, { align: "center", label: "单价（元）" }, { default: o(() => {
        var e;
        return [n("span", null, m(t(F)((e = s.currentRow) == null ? void 0 : e.price, 2) || "-"), 1)];
      }), _: 1 }), a(d, { align: "center", label: "金额（元）" }, { default: o(() => {
        var e;
        return [n("span", null, m(t(F)((e = s.currentRow) == null ? void 0 : e.totalPrice, 2) || "-"), 1)];
      }), _: 1 }), a(d, { align: "center", label: "" }), a(d, { align: "center", label: "" })];
    }), _: 1 }), a(p, { modelValue: t(l).remark, "onUpdate:modelValue": r[5] || (r[5] = (c) => t(l).remark = c), modelModifiers: { trim: true }, placeholder: "备注", type: "textarea", autosize: { minRows: 3, maxRows: 3 }, maxlength: "200", class: "remark-style" }, null, 8, ["modelValue"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, ge = Z(fe, [["__scopeId", "data-v-2344b00e"]]);
export {
  ge as default
};
