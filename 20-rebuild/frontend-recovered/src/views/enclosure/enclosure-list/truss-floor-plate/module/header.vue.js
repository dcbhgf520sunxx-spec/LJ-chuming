import { ref as g } from "vue";
import { inject as K } from "vue";
import { computed as E } from "vue";
import { watch as X } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as ee } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as A } from "vue";
import { withDirectives as k } from "vue";
import { vShow as ae } from "vue";
import { unref as e } from "vue";
import { createElementVNode as v } from "vue";
import { createCommentVNode as m } from "vue";
import { createVNode as i } from "vue";
import { normalizeStyle as te } from "vue";
import { withCtx as u } from "vue";
import { createBlock as c } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as P } from "vue";
import { resolveDynamicComponent as le } from "vue";
import { ElInput as ne } from "element-plus";
import { ElPopconfirm as oe } from "element-plus";
import { ElTag as se } from "element-plus";
import { a as re } from "../../../../../modules/area-ca564e60.js";
import { _ as ue, T as p, B as ie, C as ce, G as y, mo as x, L as B, mp as de, mq as me, D as N, aS as pe, mr as fe, E as ye, mg as _e } from "../../../../../shared/runtime.js";
import { a as ge } from "../../../../../modules/index-8356a01a.js";
import { _ as j } from "../../../../../modules/ExcelUploadBtn-acccae97.js";
import ve from "../../../../contract/project-manage/module/enclosure-table/pressed-support-table.vue.js";
import be from "../../../../contract/project-manage/module/enclosure-table/sandwich-table.vue.js";
import Ee from "../../../../contract/project-manage/module/enclosure-table/pressed-color-table.vue.js";
import Pe from "../../../../contract/project-manage/module/enclosure-table/truss-support-table.vue.js";
import we from "../../../../plan/technical-data-manage/components/drawing-upload-btn/index.vue.js";
import "../../../../../modules/index-ce9deea8.js";
const Ie = { style: { "margin-bottom": "5px" } }, Ve = { key: 0, style: { "font-size": "12px", color: "red", "margin-left": "10px" } }, Se = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, tableData: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} }, typeOption: { type: Array, default: () => [] }, sumData: { type: Object, default: () => {
} } }, emits: ["sumChange"], setup(f, { emit: L }) {
  const O = { name: void 0, serialNumber: void 0, enclosurePlanId: { value: void 0, resetAble: false }, category: { value: p.TRUSS_FLOOR_PLATE.V, resetAble: false }, thickness: void 0, plate: void 0 }, n = g({}), d = g([]), w = g({}), { crud: a, query: l, CRUD: R } = ie(O), I = g(false), z = L, V = f, S = g(false), U = K("technicalTypeStatus"), $ = E(() => {
    switch (a.query.category) {
      case p.PROFILED_PLATE.V:
        return Ee;
      case p.TRUSS_FLOOR_PLATE.V:
        return Pe;
      case p.PRESSURE_BEARING_PLATE.V:
        return ve;
      case p.SANDWICH_BOARD.V:
        return be;
      default:
        return null;
    }
  });
  X(() => V.projectId, (r) => {
    M();
  }, { deep: true, immediate: true });
  const q = E(() => ({ enclosurePlanId: a.query.enclosurePlanId, category: l.category, importType: 1 })), Q = E(() => ({ enclosurePlanId: a.query.enclosurePlanId, category: l.category, importType: 2 })), F = E(() => ({ ...a.query }));
  function G(r) {
    const { name: t, label: _ } = r;
    n.value = { id: t, name: _ }, a.toQuery();
  }
  async function M() {
    if (d.value = [], n.value = {}, w.value = {}, S.value = false, V.projectId) try {
      const r = await re(V.projectId) || [];
      d.value = r.filter((t) => t.category === a.query.category) || [], d.value && d.value.length > 0 ? w.value = { id: d.value[0].id + "", name: d.value[0].name } : S.value = true;
    } catch (r) {
      console.log("获取项目所有计划", r);
    }
  }
  async function H() {
    try {
      await _e(a.query.enclosurePlanId), a.notify("操作成功", R.NOTIFICATION_TYPE.SUCCESS), h();
    } catch (r) {
      console.log("清空区域下围护", r);
    }
  }
  function h() {
    z("sumChange"), a.toQuery();
  }
  return (r, t) => {
    const _ = ne, D = C("common-button"), W = oe, Y = se, Z = C("common-drawer"), J = ee("permission");
    return s(), A("div", null, [k(v("div", null, [v("div", Ie, [S.value ? (s(), A("span", Ve, "*当前项目下未创建计划")) : m("", true), i(e(ge), { class: "filter-item", style: te(d.value.length > 0 ? "width:calc(100% - 230px)" : "width:calc(100% - 380px)"), modelValue: e(l).enclosurePlanId, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(l).enclosurePlanId = o), "area-info": d.value, "default-tab": w.value, "show-type": 2, onTabClick: G }, null, 8, ["style", "modelValue", "area-info", "default-tab"])]), i(_, { modelValue: e(l).name, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(l).name = o), size: "default", placeholder: "输入名称搜索", style: { width: "170px", "margin-left": "0" }, class: "filter-item", clearable: "", onBlur: e(a).toQuery }, null, 8, ["modelValue", "onBlur"]), i(_, { modelValue: e(l).plate, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(l).plate = o), size: "default", placeholder: "输入板型搜索", style: { width: "170px", "margin-left": "0" }, class: "filter-item", clearable: "", onBlur: e(a).toQuery }, null, 8, ["modelValue", "onBlur"]), i(_, { modelValue: e(l).serialNumber, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(l).serialNumber = o), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onBlur: e(a).toQuery }, null, 8, ["modelValue", "onBlur"]), i(e(ce))], 512), [[ae, e(a).searchToggle]]), i(e(ye), null, { optRight: u(() => [n.value && n.value.id && e(y)(e(a).permission.import) ? (s(), c(e(j), { key: 0, data: q.value, "upload-fun": e(x), "success-msg": "导入成功", "btn-name": "清单增量导入", "btn-type": "primary", "btn-size": "default", class: "filter-item", onSuccess: h }, null, 8, ["data", "upload-fun"])) : m("", true), n.value && n.value.id && e(y)(e(a).permission.import) ? (s(), c(e(j), { key: 1, data: Q.value, "upload-fun": e(x), "success-msg": "导入成功", "btn-name": "清单覆盖导入", "btn-type": "success", "btn-size": "default", class: "filter-item", onSuccess: h }, null, 8, ["data", "upload-fun"])) : m("", true), n.value && n.value.id && e(y)(e(a).permission.save) ? (s(), c(D, { key: 2, type: "primary", size: "default", onClick: e(a).toAdd, class: "filter-item" }, { default: u(() => t[5] || (t[5] = [b("手动添加")])), _: 1, __: [5] }, 8, ["onClick"])) : m("", true), k((s(), c(B, { fn: e(de), params: { category: e(a).query.category }, class: "filter-item" }, { default: u(() => t[6] || (t[6] = [b(" 模板下载 ")])), _: 1, __: [6] }, 8, ["fn", "params"])), [[J, e(a).permission.templateDownload]]), n.value && n.value.id && e(y)(e(a).permission.download) ? (s(), c(B, { key: 3, fn: e(me), params: F.value, disabled: e(a).data.length === 0, class: "filter-item" }, { default: u(() => t[7] || (t[7] = [b(" 清单(按条件查询) ")])), _: 1, __: [7] }, 8, ["fn", "params", "disabled"])) : m("", true), n.value && n.value.id && e(y)(e(a).permission.del) ? (s(), c(W, { key: 4, title: `确认清空【${n.value.name}】下的【围护清单】么?`, onConfirm: H }, { reference: u(() => [i(D, { type: "danger", size: "default", class: "filter-item" }, { default: u(() => t[8] || (t[8] = [b("一键清空(按区域)")])), _: 1, __: [8] })]), _: 1 }, 8, ["title"])) : m("", true), i(Y, { type: "success", size: "large", effect: "plain", class: "filter-item" }, { default: u(() => [v("span", null, P(`总长度:${f.sumData.totalLength ? f.sumData.totalLength.toFixed(e(N).MES_ENCLOSURE_L__M) : 0}m`), 1), v("span", null, P(` | 总数量:${f.sumData.totalQuantity || "-"}张`), 1), v("span", null, P(` | 总面积:${f.sumData.totalArea ? f.sumData.totalArea.toFixed(e(N).COM_ENCLOSURE_AREA__M2) : 0}㎡`), 1)]), _: 1 })]), viewLeft: u(() => [e(l).category !== e(p).BENDING.V && e(a).query.projectId && e(y)(e(a).permission.techDetail) ? (s(), c(D, { key: 0, type: "primary", size: "default", onClick: t[4] || (t[4] = (o) => I.value = true) }, { default: u(() => {
      var o, T;
      return [b("技术交底配置（已" + P((T = (o = e(pe).V) == null ? void 0 : o[e(U)]) == null ? void 0 : T.L) + "）", 1)];
    }), _: 1 })) : m("", true), e(l).category === e(p).BENDING.V && e(y)(e(a).permission.draw) && e(l).enclosurePlanId ? (s(), c(e(we), { key: 1, ref: "changeFileRef", "upload-fun": e(fe), data: { enclosurePlanId: e(l).enclosurePlanId }, "btn-name": "批量上传图纸", "btn-type": "warning", "btn-size": "mini", accept: ".zip,.jpg,.jpeg,.png", class: "filter-item", onSuccess: e(a).toQuery, tip: ".jpg,.jpeg,.png" }, null, 8, ["upload-fun", "data", "onSuccess"])) : m("", true)]), _: 1 }), i(Z, { "append-to-body": "", "before-close": () => {
      I.value = false;
    }, visible: I.value, title: `技术交底(${e(l).category ? e(p).VL[e(l).category] : ""})`, size: "80%" }, { content: u(() => [(s(), c(le($.value), { "table-data": f.tableData[e(l).category], "is-show": true, style: { "margin-top": "20px" } }, null, 8, ["table-data"]))]), _: 1 }, 8, ["before-close", "visible", "title"])]);
  };
} }, Re = ue(Se, [["__scopeId", "data-v-18c93821"]]);
export {
  Re as default
};
