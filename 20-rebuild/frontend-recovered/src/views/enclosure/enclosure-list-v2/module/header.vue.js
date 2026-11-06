import { ref as f } from "vue";
import { inject as J } from "vue";
import { computed as w } from "vue";
import { watch as h } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as K } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { createBlock as g } from "vue";
import { normalizeStyle as W } from "vue";
import { createCommentVNode as I } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as A } from "vue";
import { ElInput as Z } from "element-plus";
import { ElPopconfirm as ee } from "element-plus";
import { ElTag as ae } from "element-plus";
import { _ as te, B as oe, m as le, mc as ne, m4 as se, i as re, m9 as T, C as de, G as x, md as ie, a as R, me as ue, L as O, mf as ce, D as $, mg as me, mh as pe, mi as fe } from "../../../../shared/runtime.js";
import _e from "../components/ExcelUploadBtn.vue.js";
import { g as ve } from "../../../../modules/artifact-tree-bcd3b733.js";
import { a as ye } from "../../../../modules/index-8356a01a.js";
const ge = { class: "head-container" }, Ie = { class: "monomer-batch-container" }, be = { class: "search" }, Ee = { class: "btn-container" }, he = { class: "left" }, xe = { __name: "header", setup(Ce, { expose: j }) {
  const P = { monomerId: void 0, areaId: void 0, dictionaryId: void 0, name: void 0, serialNumber: void 0, projectId: { value: void 0, resetAble: false } }, { crud: l, CRUD: V, query: t } = oe(P), { globalProjectId: z } = le("globalProjectId"), c = f({}), B = J("enclosureDictList"), M = f({ key: "id", value: "id", label: "label" }), Q = w(() => ({ areaId: t.areaId, importType: 1 })), m = f([]), d = f(), S = f({}), p = f({});
  async function F() {
    try {
      await me(l.query.areaId), l.notify("操作成功", V.NOTIFICATION_TYPE.SUCCESS), l.toQuery();
    } catch (o) {
      console.log("清空区域下围护", o);
    }
  }
  async function G() {
    try {
      const o = l.props.selectList.map((a) => a.id);
      await pe(o), l.notify("操作成功", V.NOTIFICATION_TYPE.SUCCESS), l.toQuery(), l.props.selectList = [];
    } catch (o) {
      console.log(o);
    }
  }
  async function H() {
    c.value = {};
    try {
      const o = await ve({ areaId: l.query.areaId });
      c.value = o || {};
    } catch (o) {
      console.log(o);
    }
  }
  h(z, (o) => {
    t.projectId = o, Y();
  }, { immediate: true }), h([() => t == null ? void 0 : t.monomerId, () => t == null ? void 0 : t.areaId], ([o, a]) => {
  }, { deep: true, immediate: true });
  async function Y() {
    var o;
    try {
      const a = await ne({ projectId: t.projectId });
      m.value = a.monomerList, (o = m.value) != null && o.length && (t.monomerId = m.value[0].id, D(t.monomerId));
    } catch (a) {
      console.log(a);
    }
  }
  function D(o) {
    var y;
    o || (t.areaId = void 0);
    const a = m.value.findIndex((n) => n.id === o);
    a !== -1 ? (d.value = m.value[a].areaList, d.value.forEach((n) => {
      n != null && n.specialAnnotation || (n.name = n.type == se.OUTSOURCE.V ? `${n.name} (外协)` : `${n.name} (自制)`, n.specialAnnotation = true);
    }), (y = d.value) != null && y.length && (S.value = { id: d.value[0].id + "", name: `${d.value[0].name}(${d.value[0].axis})` }), t.areaId = d.value[0].id) : d.value = [];
  }
  const q = async () => {
    try {
      const o = await fe(l.query);
      console.log(o, "getEnclosureSum"), p.value = o;
    } catch (o) {
      console.log(o, "getEnclosureSumApi");
    }
  };
  h(() => l.query, async (o) => {
    await q();
  }, { deep: true }), h(() => t.areaId, (o) => {
    o && (H(), l.toQuery());
  }, { immediate: true, deep: true });
  const E = w(() => re(c.value) ? c.value.inventoryReviewedEnum === T.FIXUP_RECORD.V || c.value.inventoryReviewedEnum === T.UNAUDITED.V : false), v = w(() => t.monomerId && t.areaId);
  return j({ inventoryReviewedData: c }), (o, a) => {
    var U;
    const y = N("common-select-v2"), n = Z, C = N("common-button"), L = ee, X = ae;
    return _(), K("div", ge, [u("div", Ie, [r(y, { modelValue: e(t).monomerId, "onUpdate:modelValue": a[0] || (a[0] = (s) => e(t).monomerId = s), options: m.value, class: "filter-item", onChange: D }, null, 8, ["modelValue", "options"]), e(t).monomerId ? (_(), g(e(ye), { key: 0, modelValue: e(t).areaId, "onUpdate:modelValue": a[1] || (a[1] = (s) => e(t).areaId = s), "area-info": d.value, "default-tab": S.value, style: W(((U = d.value) == null ? void 0 : U.length) > 0 ? "width:calc(100% - 230px)" : "width:calc(100% - 380px)"), class: "filter-item" }, null, 8, ["modelValue", "area-info", "default-tab", "style"])) : I("", true)]), u("div", be, [r(y, { modelValue: e(t).dictionaryId, "onUpdate:modelValue": a[2] || (a[2] = (s) => e(t).dictionaryId = s), "data-structure": M.value, options: e(B), class: "filter-item", clearable: "", filterable: "", placeholder: "选择类型搜索", style: { width: "160px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "data-structure", "options", "onChange"]), r(n, { modelValue: e(t).name, "onUpdate:modelValue": a[3] || (a[3] = (s) => e(t).name = s), class: "filter-item", placeholder: "输入名称搜索", style: { width: "160px" } }, null, 8, ["modelValue"]), r(n, { modelValue: e(t).serialNumber, "onUpdate:modelValue": a[4] || (a[4] = (s) => e(t).serialNumber = s), class: "filter-item", placeholder: "输入编号搜索", style: { width: "160px" } }, null, 8, ["modelValue"]), r(de)]), u("div", Ee, [u("div", he, [e(x)(e(l).permission.add) ? (_(), g(C, { key: 0, disabled: v.value ? E.value : true, class: "filter-item", size: "default", type: "primary", onClick: e(l).toAdd }, { default: i(() => a[5] || (a[5] = [b(" 手动添加 ")])), _: 1, __: [5] }, 8, ["disabled", "onClick"])) : I("", true), e(x)(e(l).permission.add) ? (_(), g(_e, { key: 1, data: Q.value, disabled: v.value ? E.value : true, "upload-fun": e(ie), "btn-name": "清单增量导入", "btn-type": "success", class: "filter-item upload", style: { height: "32px" }, "success-msg": "导入成功", onSuccess: e(l).toQuery }, null, 8, ["data", "disabled", "upload-fun", "onSuccess"])) : I("", true), e(x)(e(l).permission.download) ? (_(), g(O, { key: 2, disabled: !v.value, fn: e(ue), class: "filter-item", icon: "" }, { default: i(() => [r(R, { "icon-class": "mes-cloud-download", style: { "margin-right": "5px", "font-size": "16px" } }), a[6] || (a[6] = b(" 清单模板 "))]), _: 1 }, 8, ["disabled", "fn"])) : I("", true), e(x)(e(l).permission.download) ? (_(), g(O, { key: 3, disabled: !v.value, fn: e(ce), params: e(t), class: "filter-item", icon: "" }, { default: i(() => [r(R, { "icon-class": "mes-cloud-download", style: { "margin-right": "5px", "font-size": "16px" } }), a[7] || (a[7] = b(" 清单(按条件查询) "))]), _: 1 }, 8, ["disabled", "fn", "params"])) : I("", true), r(L, { title: "确认清空?", onConfirm: F }, { reference: i(() => [r(C, { disabled: v.value ? E.value : true, class: "filter-item", icon: "el-icon-delete", size: "default", style: { "margin-left": "0px" }, type: "danger" }, { default: i(() => a[8] || (a[8] = [b(" 一键清空 ")])), _: 1, __: [8] }, 8, ["disabled"])]), _: 1 }), r(L, { title: "确认删除吗?", onConfirm: G }, { reference: i(() => {
      var s, k;
      return [r(C, { disabled: !((k = (s = e(l).props) == null ? void 0 : s.selectList) != null && k.length) > 0 || E.value, class: "filter-item", icon: "el-icon-delete", size: "default", style: { "margin-left": "0px" }, type: "danger" }, { default: i(() => a[9] || (a[9] = [b(" 批量【未排产围护】 ")])), _: 1, __: [9] }, 8, ["disabled"])];
    }), _: 1 }), r(X, { class: "filter-item", effect: "plain", size: "large", type: "success" }, { default: i(() => [u("span", null, A(`总长度:${p.value.totalLength ? p.value.totalLength.toFixed(e($).MES_ENCLOSURE_L__M) : 0}m`), 1), u("span", null, A(` | 总数量:${p.value.totalQuantity || 0}张`), 1), u("span", null, A(` | 总面积:${p.value.totalArea ? p.value.totalArea.toFixed(e($).COM_ENCLOSURE_AREA__M2) : 0}㎡`), 1)]), _: 1 })])])]);
  };
} }, Le = te(xe, [["__scopeId", "data-v-f6584b90"]]);
export {
  Le as default
};
