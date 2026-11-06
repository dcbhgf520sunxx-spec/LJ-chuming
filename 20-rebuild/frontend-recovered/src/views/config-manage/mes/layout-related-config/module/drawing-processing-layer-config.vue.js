import { ref as _ } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as t } from "vue";
import { createBlock as r } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as g } from "vue";
import { createTextVNode as w } from "vue";
import { createCommentVNode as x } from "vue";
import { unref as l } from "vue";
import { createElementBlock as p } from "vue";
import { Fragment as $ } from "vue";
import { createVNode as u } from "vue";
import { withDirectives as W } from "vue";
import { toDisplayString as C } from "vue";
import { ElNotification as J } from "element-plus";
import { WarningFilled as Q } from "@element-plus/icons-vue";
import { ElIcon as X } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElInput as ee } from "element-plus";
import { ElCard as ae } from "element-plus";
import { vLoading as te } from "element-plus";
import { l as I, _ as le, o as oe, G as E, fw as N, fx as v, fy as f, i as ne, V as z, aw as se } from "../../../../../shared/runtime.js";
function ie(y) {
  return I({ url: "/api/config/part-drawing-layer-setting/get", method: "get", params: y });
}
function re(y) {
  return I({ url: "/api/config/part-drawing-layer-setting/edit", method: "post", data: y });
}
const de = { class: "header" }, ce = { class: "explain" }, ue = { key: 1 }, pe = { key: 1 }, me = { key: 1 }, _e = { key: 0, class: "add-button" }, ge = { key: 1, class: "tips" }, fe = { __name: "drawing-processing-layer-config", setup(y) {
  const { maxHeight: L } = oe({ extraBox: [".el-card__header", ".add-button", ".explain"], wrapperBox: [".app-container", ".el-card__body"], minHeight: 300, extraHeight: 60 }), d = _([]), b = _(false), s = _(false), T = _(), V = _(false);
  async function M() {
    b.value = true;
    let n = [];
    try {
      const e = await ie();
      e.forEach((i) => {
        ne(i.objectType) || (i.objectType = f.ENTITY.V);
      }), n = e || [];
    } catch (e) {
      console.log("获取零件图纸加工图层配置", e);
    } finally {
      b.value = false, d.value = n || [], T.value = z(n) || [];
    }
  }
  const P = { layerName: [{ required: true, message: "请输入名称", trigger: "blur" }], processMethod: [{ required: true, message: "请选择处理方式", trigger: "change" }], objectType: [{ required: true, message: "请选择实体类型", trigger: "change" }] }, { tableValidate: U, wrongCellMask: B } = se({ rules: P });
  function R() {
    s.value = true;
  }
  function S() {
    d.value = z(T.value), s.value = false;
  }
  function D(n, e) {
    e !== v.PROCESS_MARKING.V && (n.objectType = f.ENTITY.V);
  }
  function H() {
    d.value.push({ layerName: void 0, processMethod: void 0, objectType: f.ENTITY.V });
  }
  function q(n) {
    d.value.splice(n, 1);
  }
  async function G() {
    var n;
    V.value = true;
    try {
      let e = [];
      if (d.value.length > 0) {
        const { validResult: i } = U(d.value);
        if (!i) return;
        e = (n = d.value) == null ? void 0 : n.filter((h) => h.layerName && h.processMethod);
      }
      await re(e), J({ title: "零件图纸加工图层配置成功", type: "success", duration: 2500 }), M(), s.value = false;
    } catch (e) {
      console.log("设置零件图纸加工图层配置", e);
    } finally {
      V.value = false;
    }
  }
  return M(), (n, e) => {
    const i = k("common-button"), h = Q, Y = X, m = Z, A = ee, j = k("common-select"), F = k("common-table"), K = ae, O = te;
    return t(), r(K, { shadow: "always" }, { header: o(() => [g("div", de, [e[3] || (e[3] = g("span", { class: "card-title" }, "零件图纸加工图层设置", -1)), g("div", null, [s.value ? (t(), r(i, { key: 0, loading: V.value, size: "default", type: "success", onClick: G }, { default: o(() => e[0] || (e[0] = [w(" 保存 ")])), _: 1, __: [0] }, 8, ["loading"])) : x("", true), !s.value && l(E)(l(N).edit) && l(E)(l(N).get) ? (t(), r(i, { key: 1, size: "default", type: "primary", onClick: R }, { default: o(() => e[1] || (e[1] = [w(" 编辑 ")])), _: 1, __: [1] })) : (t(), r(i, { key: 2, size: "default", type: "warning", onClick: S }, { default: o(() => e[2] || (e[2] = [w("取消编辑")])), _: 1, __: [2] }))])])]), default: o(() => [l(E)(l(N).get) ? (t(), p($, { key: 0 }, [g("div", ce, [u(Y, { color: "#e6a23c", size: "26px" }, { default: o(() => [u(h)]), _: 1 }), e[4] || (e[4] = g("span", { class: "explain-text" }, " 默认所有图层都进行加工，可以将文字、打标、喷墨等图层设置进“不加工/打标图层中”。", -1))]), W((t(), r(F, { maxHeight: l(L), data: d.value, "return-source-data": "", "cell-class-name": l(B), "show-empty-symbol": false }, { default: o(() => [u(m, { label: "序号", type: "index", align: "center", width: "60" }), u(m, { prop: "layerName", label: "不加工/打标图层名称（英文区分大小写）", align: "center", "min-width": "140" }, { default: o((a) => [s.value ? (t(), r(A, { key: 0, modelValue: a.row.layerName, "onUpdate:modelValue": (c) => a.row.layerName = c, size: "default", maxlength: "50", placeholder: "请输入名称", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), p("span", ue, C(a.row.layerName || "-"), 1))]), _: 1 }), u(m, { prop: "processMethod", label: "处理方式", align: "center", width: "130" }, { default: o((a) => [s.value ? (t(), r(j, { key: 0, modelValue: a.row.processMethod, "onUpdate:modelValue": (c) => a.row.processMethod = c, options: l(v).ENUM, type: "enum", size: "default", placeholder: "类型", class: "filter-item", style: { width: "100%" }, onChange: (c) => D(a.row, c) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (t(), p("span", pe, C(l(v).VL[a.row.processMethod] || "-"), 1))]), _: 1 }), u(m, { prop: "objectType", label: "实体类型", align: "center", width: "130" }, { default: o((a) => [s.value && a.row.processMethod === l(v).PROCESS_MARKING.V ? (t(), r(j, { key: 0, modelValue: a.row.objectType, "onUpdate:modelValue": (c) => a.row.objectType = c, options: l(f).ENUM, type: "enum", size: "default", placeholder: "类型", class: "filter-item", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (t(), p("span", me, C(l(f).VL[a.row.objectType] || "-"), 1))]), _: 1 }), s.value ? (t(), r(m, { key: 0, label: "操作", width: "100", align: "center" }, { default: o((a) => [u(i, { size: "default", type: "danger", icon: "el-icon-delete", onClick: (c) => q(a.$index), style: { padding: "6px" } }, null, 8, ["onClick"])]), _: 1 })) : x("", true)]), _: 1 }, 8, ["maxHeight", "data", "cell-class-name"])), [[O, b.value]]), s.value ? (t(), p("div", _e, [u(i, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-top": "15px" }, onClick: H }, { default: o(() => e[5] || (e[5] = [w(" 新增图层 ")])), _: 1, __: [5] })])) : x("", true)], 64)) : (t(), p("div", ge, "暂无权限"))]), _: 1 });
  };
} }, we = le(fe, [["__scopeId", "data-v-330fcf85"]]);
export {
  we as default
};
