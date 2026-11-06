import { ref as _ } from "vue";
import { inject as X } from "vue";
import { computed as E } from "vue";
import { watch as ee } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as ae } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as k } from "vue";
import { withDirectives as x } from "vue";
import { vShow as te } from "vue";
import { unref as e } from "vue";
import { createElementVNode as g } from "vue";
import { createCommentVNode as d } from "vue";
import { createVNode as i } from "vue";
import { normalizeStyle as le } from "vue";
import { withCtx as u } from "vue";
import { createBlock as c } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as I } from "vue";
import { resolveDynamicComponent as ne } from "vue";
import { ElInput as oe } from "element-plus";
import { ElInputNumber as se } from "element-plus";
import { ElPopconfirm as re } from "element-plus";
import { ElTag as ue } from "element-plus";
import { a as ie } from "../../../../../modules/area-ca564e60.js";
import { _ as ce, T as p, B as me, D as C, C as de, G as y, mo as A, L as j, mp as pe, mq as fe, aS as ye, mr as _e, E as ge, mg as ve } from "../../../../../shared/runtime.js";
import { a as be } from "../../../../../modules/index-8356a01a.js";
import { _ as B } from "../../../../../modules/ExcelUploadBtn-acccae97.js";
import Ee from "../../../../contract/project-manage/module/enclosure-table/pressed-support-table.vue.js";
import Ie from "../../../../contract/project-manage/module/enclosure-table/sandwich-table.vue.js";
import Pe from "../../../../contract/project-manage/module/enclosure-table/pressed-color-table.vue.js";
import he from "../../../../contract/project-manage/module/enclosure-table/truss-support-table.vue.js";
import we from "../../../../plan/technical-data-manage/components/drawing-upload-btn/index.vue.js";
import "../../../../../modules/index-ce9deea8.js";
const Ve = { style: { "margin-bottom": "5px" } }, Se = { key: 0, style: { "font-size": "12px", color: "red", "margin-left": "10px" } }, De = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, tableData: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} }, typeOption: { type: Array, default: () => [] }, sumData: { type: Object, default: () => {
} } }, emits: ["sumChange"], setup(f, { emit: L }) {
  const O = { name: void 0, serialNumber: void 0, enclosurePlanId: { value: void 0, resetAble: false }, category: { value: p.BENDING.V, resetAble: false }, thickness: void 0, plate: void 0 }, R = L, n = _({}), m = _([]), P = _({}), { crud: a, query: l, CRUD: z } = me(O), h = _(false), w = f, V = _(false), U = X("technicalTypeStatus"), $ = E(() => {
    switch (a.query.category) {
      case p.PROFILED_PLATE.V:
        return Pe;
      case p.TRUSS_FLOOR_PLATE.V:
        return he;
      case p.PRESSURE_BEARING_PLATE.V:
        return Ee;
      case p.SANDWICH_BOARD.V:
        return Ie;
      default:
        return null;
    }
  });
  ee(() => w.projectId, (r) => {
    G();
  }, { deep: true, immediate: true });
  const q = E(() => ({ enclosurePlanId: a.query.enclosurePlanId, category: l.category, importType: 1 })), M = E(() => ({ enclosurePlanId: a.query.enclosurePlanId, category: l.category, importType: 2 })), Q = E(() => ({ ...a.query }));
  function F(r) {
    const { name: t, label: b } = r;
    n.value = { id: t, name: b }, a.toQuery();
  }
  async function G() {
    if (m.value = [], n.value = {}, P.value = {}, V.value = false, w.projectId) try {
      const r = await ie(w.projectId) || [];
      m.value = r.filter((t) => t.category === a.query.category) || [], m.value && m.value.length > 0 ? P.value = { id: m.value[0].id + "", name: m.value[0].name } : V.value = true;
    } catch (r) {
      console.log("获取项目所有计划", r);
    }
  }
  async function H() {
    try {
      await ve(a.query.enclosurePlanId), a.notify("操作成功", z.NOTIFICATION_TYPE.SUCCESS), S();
    } catch (r) {
      console.log("清空区域下围护", r);
    }
  }
  function S() {
    R("sumChange"), a.toQuery();
  }
  return (r, t) => {
    const b = oe, W = se, D = N("common-button"), Y = re, Z = ue, J = N("common-drawer"), K = ae("permission");
    return s(), k("div", null, [x(g("div", null, [g("div", Ve, [V.value ? (s(), k("span", Se, "*当前项目下未创建计划")) : d("", true), i(e(be), { class: "filter-item", style: le(m.value.length > 0 ? "width:calc(100% - 230px)" : "width:calc(100% - 380px)"), modelValue: e(l).enclosurePlanId, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(l).enclosurePlanId = o), "area-info": m.value, "default-tab": P.value, "show-type": 2, onTabClick: F }, null, 8, ["style", "modelValue", "area-info", "default-tab"])]), i(b, { modelValue: e(l).name, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(l).name = o), size: "default", placeholder: "输入名称搜索", style: { width: "170px", "margin-left": "0" }, class: "filter-item", clearable: "", onBlur: e(a).toQuery }, null, 8, ["modelValue", "onBlur"]), i(b, { modelValue: e(l).serialNumber, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(l).serialNumber = o), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onBlur: e(a).toQuery }, null, 8, ["modelValue", "onBlur"]), i(W, { modelValue: e(l).thickness, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(l).thickness = o), modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: e(C).MES_ENCLOSURE_T__MM, placeholder: "输入厚度搜索", "controls-position": "right", controls: false, class: "filter-item left-num", style: { width: "170px" } }, null, 8, ["modelValue", "precision"]), i(e(de))], 512), [[te, e(a).searchToggle]]), i(e(ge), null, { optRight: u(() => [n.value && n.value.id && e(y)(e(a).permission.import) ? (s(), c(e(B), { key: 0, data: q.value, "upload-fun": e(A), "success-msg": "导入成功", "btn-name": "清单增量导入", "btn-type": "primary", "btn-size": "default", class: "filter-item", onSuccess: S }, null, 8, ["data", "upload-fun"])) : d("", true), n.value && n.value.id && e(y)(e(a).permission.import) ? (s(), c(e(B), { key: 1, data: M.value, "upload-fun": e(A), "success-msg": "导入成功", "btn-name": "清单覆盖导入", "btn-type": "success", "btn-size": "default", class: "filter-item", onSuccess: S }, null, 8, ["data", "upload-fun"])) : d("", true), n.value && n.value.id && e(y)(e(a).permission.save) ? (s(), c(D, { key: 2, type: "primary", size: "default", onClick: e(a).toAdd, class: "filter-item" }, { default: u(() => t[5] || (t[5] = [v("手动添加")])), _: 1, __: [5] }, 8, ["onClick"])) : d("", true), x((s(), c(j, { fn: e(pe), params: { category: e(a).query.category }, class: "filter-item" }, { default: u(() => t[6] || (t[6] = [v(" 模板下载 ")])), _: 1, __: [6] }, 8, ["fn", "params"])), [[K, e(a).permission.templateDownload]]), n.value && n.value.id && e(y)(e(a).permission.download) ? (s(), c(j, { key: 3, fn: e(fe), params: Q.value, disabled: e(a).data.length === 0, class: "filter-item" }, { default: u(() => t[7] || (t[7] = [v(" 清单(按条件查询) ")])), _: 1, __: [7] }, 8, ["fn", "params", "disabled"])) : d("", true), n.value && n.value.id && e(y)(e(a).permission.del) ? (s(), c(Y, { key: 4, title: `确认清空【${n.value.name}】下的【围护清单】么?`, onConfirm: H }, { reference: u(() => [i(D, { type: "danger", size: "default", class: "filter-item" }, { default: u(() => t[8] || (t[8] = [v("一键清空(按区域)")])), _: 1, __: [8] })]), _: 1 }, 8, ["title"])) : d("", true), i(Z, { type: "success", size: "large", effect: "plain", class: "filter-item" }, { default: u(() => [g("span", null, I(`总长度:${f.sumData.totalLength ? f.sumData.totalLength.toFixed(e(C).MES_ENCLOSURE_L__M) : 0}m`), 1), g("span", null, I(` | 总数量:${f.sumData.totalQuantity || 0}张`), 1), g("span", null, I(` | 总面积:${f.sumData.totalArea ? f.sumData.totalArea.toFixed(e(C).COM_ENCLOSURE_AREA__M2) : 0}㎡`), 1)]), _: 1 })]), viewLeft: u(() => [e(l).category !== e(p).BENDING.V && e(a).query.projectId && e(y)(e(a).permission.techDetail) ? (s(), c(D, { key: 0, type: "primary", size: "default", onClick: t[4] || (t[4] = (o) => h.value = true) }, { default: u(() => {
      var o, T;
      return [v("技术交底配置（已" + I((T = (o = e(ye).V) == null ? void 0 : o[e(U)]) == null ? void 0 : T.L) + "）", 1)];
    }), _: 1 })) : d("", true), e(l).category === e(p).BENDING.V && e(y)(e(a).permission.draw) && e(l).enclosurePlanId ? (s(), c(e(we), { key: 1, ref: "changeFileRef", "upload-fun": e(_e), data: { enclosurePlanId: e(l).enclosurePlanId }, "btn-name": "批量上传图纸", "btn-type": "warning", "btn-size": "mini", accept: ".zip,.jpg,.jpeg,.png", class: "filter-item", onSuccess: e(a).toQuery, tip: ".jpg,.jpeg,.png" }, null, 8, ["upload-fun", "data", "onSuccess"])) : d("", true)]), _: 1 }), i(J, { "append-to-body": "", "before-close": () => {
      h.value = false;
    }, visible: h.value, title: `技术交底(${e(l).category ? e(p).VL[e(l).category] : ""})`, size: "80%" }, { content: u(() => [(s(), c(ne($.value), { "table-data": f.tableData[e(l).category], "is-show": true, style: { "margin-top": "20px" } }, null, 8, ["table-data"]))]), _: 1 }, 8, ["before-close", "visible", "title"])]);
  };
} }, Ue = ce(De, [["__scopeId", "data-v-27bcea04"]]);
export {
  Ue as default
};
