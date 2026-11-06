import { ref as p } from "vue";
import { inject as te } from "vue";
import { computed as I } from "vue";
import { watch as le } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as oe } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as ne } from "vue";
import { withDirectives as q } from "vue";
import { vShow as re } from "vue";
import { unref as e } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as u } from "vue";
import { normalizeStyle as se } from "vue";
import { withCtx as i } from "vue";
import { createBlock as m } from "vue";
import { createCommentVNode as d } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as C } from "vue";
import { resolveDynamicComponent as ue } from "vue";
import { ElInput as ie } from "element-plus";
import { ElPopconfirm as me } from "element-plus";
import { ElTag as de } from "element-plus";
import { tK as ce, B as pe, T as f, q as fe, C as ye, G as y, mo as z, L as P, mp as ge, mq as ve, D as be, aS as _e, mr as Ve, E as Ie, mk as we, mg as Se } from "../../../../../shared/runtime.js";
import { a as he } from "../../../../../modules/index-8356a01a.js";
import { _ as U } from "../../../../../modules/ExcelUploadBtn-acccae97.js";
import Ee from "../../../../contract/project-manage/module/enclosure-table/pressed-support-table.vue.js";
import Te from "../../../../contract/project-manage/module/enclosure-table/sandwich-table.vue.js";
import ke from "../../../../contract/project-manage/module/enclosure-table/pressed-color-table.vue.js";
import Ce from "../../../../contract/project-manage/module/enclosure-table/truss-support-table.vue.js";
import Ae from "../../../technical-data-manage/components/drawing-upload-btn/index.vue.js";
import "../../../../../modules/index-ce9deea8.js";
const xe = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, tableData: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} }, typeOption: { type: Array, default: () => [] } }, emits: ["tableAdd", "categoryChange"], setup(S, { emit: L }) {
  const O = { name: void 0, serialNumber: void 0, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, category: { value: void 0, resetAble: false }, createType: { value: ce.UPLOAD.V, resetAble: false }, thickness: void 0, plate: void 0 }, R = p(), r = p({}), c = p([]), b = p({}), { crud: a, query: l, CRUD: j } = pe(O), h = p(false), x = L, A = S, Q = { key: "no", label: "name", value: "no" }, _ = p([]), g = p({}), $ = te("technicalTypeStatus"), F = I(() => {
    switch (a.query.category) {
      case f.PROFILED_PLATE.V:
        return ke;
      case f.TRUSS_FLOOR_PLATE.V:
        return Ce;
      case f.PRESSURE_BEARING_PLATE.V:
        return Ee;
      case f.SANDWICH_BOARD.V:
        return Te;
      default:
        return null;
    }
  });
  le(() => A.typeOption, (n) => {
    l.category = (n == null ? void 0 : n.length) > 0 ? n[0].no : void 0;
  }, { deep: true, immediate: true });
  const G = I(() => ({ areaId: a.query.areaId, category: l.category, importType: 1 })), H = I(() => ({ areaId: a.query.areaId, category: l.category, importType: 2 })), M = I(() => ({ ...a.query }));
  function K() {
    D(), B(), x("categoryChange"), a.data = [], a.toQuery();
  }
  function D() {
    r.value = {}, c.value = a.query.category && _.value.length > 0 ? _.value.filter((n) => n.productType === a.query.category) : _.value, c.value.length > 0 ? b.value = { id: c.value[0].id + "", name: c.value[0].name } : b.value = {}, r.value = { ...b.value };
  }
  function W(n) {
    const { name: t, label: E } = n;
    r.value = { id: t, name: E }, a.toQuery();
  }
  function Y(n) {
    _.value = n || [], D(), B();
  }
  async function B() {
    if (a.query.monomerId && a.query.category) try {
      g.value = await we({ monomerId: a.query.monomerId, category: a.query.category });
    } catch (n) {
      console.log("获取围护汇总", n);
    }
    else g.value = {};
  }
  async function Z() {
    try {
      await Se(a.query.areaId), a.notify("操作成功", j.NOTIFICATION_TYPE.SUCCESS), a.toQuery();
    } catch (n) {
      console.log("清空区域下围护", n);
    }
  }
  return (n, t) => {
    const E = k("common-radio-button"), V = ie, T = k("common-button"), J = me, X = de, ee = k("common-drawer"), ae = oe("permission");
    return s(), ne("div", null, [q(w("div", null, [w("div", null, [u(E, { modelValue: e(l).category, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(l).category = o), options: S.typeOption, type: "other", dataStructure: Q, class: "filter-item", onChange: K }, null, 8, ["modelValue", "options"])]), u(e(fe), { ref_key: "monomerSelectRef", ref: R, modelValue: e(l).monomerId, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(l).monomerId = o), "project-id": A.projectId, class: "filter-item", "show-tips": c.value.length <= 0, onGetAreaInfo: Y }, null, 8, ["modelValue", "project-id", "show-tips"]), u(e(he), { class: "filter-item", style: se(c.value.length > 0 ? "width:calc(100% - 230px)" : "width:calc(100% - 380px)"), modelValue: e(l).areaId, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(l).areaId = o), "area-info": c.value, "default-tab": b.value, "show-type": 2, onTabClick: W }, null, 8, ["style", "modelValue", "area-info", "default-tab"]), u(V, { modelValue: e(l).name, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(l).name = o), size: "default", placeholder: "输入名称搜索", style: { width: "170px", "margin-left": "0" }, class: "filter-item", clearable: "", onBlur: e(a).toQuery }, null, 8, ["modelValue", "onBlur"]), u(V, { modelValue: e(l).plate, "onUpdate:modelValue": t[4] || (t[4] = (o) => e(l).plate = o), size: "default", placeholder: "输入板型搜索", style: { width: "170px", "margin-left": "0" }, class: "filter-item", clearable: "", onBlur: e(a).toQuery }, null, 8, ["modelValue", "onBlur"]), u(V, { modelValue: e(l).serialNumber, "onUpdate:modelValue": t[5] || (t[5] = (o) => e(l).serialNumber = o), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onBlur: e(a).toQuery }, null, 8, ["modelValue", "onBlur"]), u(V, { modelValue: e(l).thickness, "onUpdate:modelValue": t[6] || (t[6] = (o) => e(l).thickness = o), size: "default", placeholder: "输入厚度搜索", style: { width: "170px", "margin-left": "0" }, class: "filter-item", clearable: "", onBlur: e(a).toQuery }, null, 8, ["modelValue", "onBlur"]), u(e(ye))], 512), [[re, e(a).searchToggle]]), u(e(Ie), null, { optRight: i(() => [r.value && r.value.id && e(y)(e(a).permission.import) ? (s(), m(e(U), { key: 0, data: G.value, "upload-fun": e(z), "success-msg": "导入成功", "btn-name": "清单增量导入", "btn-type": "primary", "btn-size": "default", class: "filter-item", onSuccess: e(a).toQuery }, null, 8, ["data", "upload-fun", "onSuccess"])) : d("", true), r.value && r.value.id && e(y)(e(a).permission.import) ? (s(), m(e(U), { key: 1, data: H.value, "upload-fun": e(z), "success-msg": "导入成功", "btn-name": "清单覆盖导入", "btn-type": "success", "btn-size": "default", class: "filter-item", onSuccess: e(a).toQuery }, null, 8, ["data", "upload-fun", "onSuccess"])) : d("", true), r.value && r.value.id && e(y)(e(a).permission.save) ? (s(), m(T, { key: 2, type: "primary", size: "default", onClick: e(a).toAdd, class: "filter-item" }, { default: i(() => t[8] || (t[8] = [v("手动添加")])), _: 1, __: [8] }, 8, ["onClick"])) : d("", true), q((s(), m(P, { fn: e(ge), params: { category: e(a).query.category }, class: "filter-item" }, { default: i(() => t[9] || (t[9] = [v(" 模板下载 ")])), _: 1, __: [9] }, 8, ["fn", "params"])), [[ae, e(a).permission.templateDownload]]), r.value && r.value.id && e(y)(e(a).permission.download) ? (s(), m(P, { key: 3, fn: e(ve), params: M.value, disabled: e(a).data.length === 0, class: "filter-item" }, { default: i(() => t[10] || (t[10] = [v(" 清单(按条件查询) ")])), _: 1, __: [10] }, 8, ["fn", "params", "disabled"])) : d("", true), r.value && r.value.id && e(y)(e(a).permission.del) ? (s(), m(J, { key: 4, title: `确认清空【${r.value.name}】下的【围护清单】么?`, onConfirm: Z }, { reference: i(() => [u(T, { type: "danger", size: "default", class: "filter-item" }, { default: i(() => t[11] || (t[11] = [v("一键清空(按区域)")])), _: 1, __: [11] })]), _: 1 }, 8, ["title"])) : d("", true), g.value.totalLength ? (s(), m(X, { key: 5, type: "success", size: "large", effect: "plain", class: "filter-item" }, { default: i(() => [w("span", null, C(`总长度:${g.value.totalLength.toFixed(e(be).MES_ENCLOSURE_L__M)}m`), 1), w("span", null, C(` | 总数量:${g.value.totalQuantity}张`), 1)]), _: 1 })) : d("", true)]), viewLeft: i(() => [e(l).category !== e(f).BENDING.V && e(y)(e(a).permission.techDetail) ? (s(), m(T, { key: 0, type: "primary", size: "default", onClick: t[7] || (t[7] = (o) => h.value = true) }, { default: i(() => {
      var o, N;
      return [v("技术交底配置（已" + C((N = (o = e(_e).V) == null ? void 0 : o[e($)]) == null ? void 0 : N.L) + "）", 1)];
    }), _: 1 })) : d("", true), e(l).category === e(f).BENDING.V && e(y)(e(a).permission.draw) && e(l).areaId ? (s(), m(e(Ae), { key: 1, ref: "changeFileRef", "upload-fun": e(Ve), data: { areaId: e(l).areaId }, "btn-name": "批量上传图纸", "btn-type": "warning", "btn-size": "mini", accept: ".zip,.jpg,.jpeg,.png", class: "filter-item", onSuccess: e(a).toQuery, tip: ".jpg,.jpeg,.png" }, null, 8, ["upload-fun", "data", "onSuccess"])) : d("", true)]), _: 1 }), u(ee, { "append-to-body": "", "before-close": () => {
      h.value = false;
    }, visible: h.value, title: `技术交底(${e(l).category ? e(f).VL[e(l).category] : ""})`, size: "80%" }, { content: i(() => [(s(), m(ue(F.value), { "table-data": S.tableData[e(l).category], "is-show": true, style: { "margin-top": "20px" } }, null, 8, ["table-data"]))]), _: 1 }, 8, ["before-close", "visible", "title"])]);
  };
} };
export {
  xe as default
};
