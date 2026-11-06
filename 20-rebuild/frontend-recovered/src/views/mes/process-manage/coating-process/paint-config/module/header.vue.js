import { computed as T } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as E } from "vue";
import { createVNode as i } from "vue";
import { unref as l } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as f } from "vue";
import { Fragment as b } from "vue";
import { renderList as C } from "vue";
import { createBlock as x } from "vue";
import { ElMessageBox as Q } from "element-plus";
import { ElNotification as h } from "element-plus";
import { ElOption as U } from "element-plus";
import { ElSelect as $ } from "element-plus";
import { p as z, a as M, b as D } from "../../../../../../modules/paint-config-780a81bc.js";
import { i as d, B as I, L as j, bY as q, C as F } from "../../../../../../shared/runtime.js";
import { _ as H } from "../../../../../../modules/ExcelUploadBtn-acccae97.js";
const G = { __name: "header", props: { paintSelectList: { type: Array, default: () => [] }, paintBrandList: { type: Array, default: () => [] }, paintTypeList: { type: Array, default: () => [] } }, emits: ["success"], setup(V, { emit: k }) {
  const y = k, m = V, v = { paintingTypeEnum: void 0, paintBrand: void 0, paintType: void 0 }, w = T(() => {
    var e, o;
    let t = [];
    return d(n.paintingTypeEnum) ? (t = (e = m.paintSelectList) == null ? void 0 : e.find((p) => p.id === n.paintingTypeEnum), ((o = t == null ? void 0 : t.nameInfos) == null ? void 0 : o.map((p) => p.name)) || []) : m.paintBrandList;
  }), L = T(() => {
    let t = [];
    return t = m.paintTypeList.filter((e) => d(n.paintingTypeEnum) && d(n.paintBrand) ? e.paintingTypeEnum === n.paintingTypeEnum && e.paintBrand === n.paintBrand : d(n.paintingTypeEnum) ? e.paintingTypeEnum === n.paintingTypeEnum : d(n.paintBrand) ? e.paintBrand === n.paintBrand : e), t = t.map((e) => e.paintType), t = Array.from(new Set(t)), t;
  });
  function N() {
    n.paintBrand = void 0, n.paintType = void 0, s.toQuery();
  }
  function S() {
    n.paintType = void 0, s.toQuery();
  }
  async function A() {
    try {
      await Q.confirm("此操作将清空数据，清空后无法恢复数据，是否确认？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", customClass: "paint-config-elMessageBox", type: "warning" }), await D(), s.refresh(), h({ title: "清空成功！", type: "success", duration: 3e3 }), y("success");
    } catch (t) {
      console.log("一键清空", t);
    }
  }
  const { crud: s, query: n } = I(v);
  return (t, e) => {
    const o = B("common-button"), p = B("common-select"), g = U, _ = $;
    return r(), c("div", null, [E("div", null, [i(l(H), { "upload-fun": l(z), "success-msg": "导入成功", "btn-name": "批量导入", "btn-type": "primary", "btn-size": "default", icon: "el-icon-plus", onSuccess: e[0] || (e[0] = (a) => y("success")), class: "filter-item" }, null, 8, ["upload-fun"]), i(o, { type: "success", size: "default", class: "filter-item", onClick: l(s).toAdd }, { default: u(() => e[4] || (e[4] = [f(" 添加 ")])), _: 1, __: [4] }, 8, ["onClick"]), i(j, { fn: l(M), class: "filter-item" }, { default: u(() => e[5] || (e[5] = [f(" 导入模板下载 ")])), _: 1, __: [5] }, 8, ["fn"]), i(o, { type: "danger", size: "default", class: "filter-item", onClick: A }, { default: u(() => e[6] || (e[6] = [f(" 一键清空 ")])), _: 1, __: [6] })]), E("div", null, [i(p, { type: "enum", modelValue: l(n).paintingTypeEnum, "onUpdate:modelValue": e[1] || (e[1] = (a) => l(n).paintingTypeEnum = a), options: l(q).ENUM, clearable: "", placeholder: "涂装类型筛选", style: { width: "200px" }, class: "filter-item", onChange: N }, null, 8, ["modelValue", "options"]), i(_, { modelValue: l(n).paintBrand, "onUpdate:modelValue": e[2] || (e[2] = (a) => l(n).paintBrand = a), clearable: "", filterable: "", placeholder: "请选择品牌", class: "filter-item", style: { width: "270px" }, onChange: S }, { default: u(() => [(r(true), c(b, null, C(w.value, (a) => (r(), x(g, { key: a, label: a, value: a }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"]), i(_, { modelValue: l(n).paintType, "onUpdate:modelValue": e[3] || (e[3] = (a) => l(n).paintType = a), clearable: "", filterable: "", placeholder: "请选择材质", class: "filter-item", style: { width: "270px" }, onChange: l(s).toQuery }, { default: u(() => [(r(true), c(b, null, C(L.value, (a) => (r(), x(g, { key: a, label: a, value: a }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "onChange"]), i(l(F))])]);
  };
} };
export {
  G as default
};
