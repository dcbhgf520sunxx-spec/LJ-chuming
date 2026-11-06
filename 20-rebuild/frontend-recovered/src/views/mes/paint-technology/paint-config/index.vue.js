import { ref as g } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as y } from "vue";
import { createBlock as b } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as e } from "vue";
import { unref as t } from "vue";
import { withDirectives as A } from "vue";
import { toDisplayString as H } from "vue";
import { withModifiers as w } from "vue";
import { isRef as D } from "vue";
import { ElMessageBox as M } from "element-plus";
import { ElMessage as O } from "element-plus";
import { ElTableColumn as P } from "element-plus";
import { vLoading as U } from "element-plus";
import { c as $, d as q } from "../../../../modules/paint-config-780a81bc.js";
import { u as N, o as Q, x as j, bY as z, P as F } from "../../../../shared/runtime.js";
import G from "./module/form.vue.js";
import I from "./module/header.vue.js";
import "../../../../modules/ExcelUploadBtn-acccae97.js";
const K = { class: "head-container" }, te = { __name: "index", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} }, paintSelectList: { type: Array, default: () => [] }, paintBrandList: { type: Array, default: () => [] }, paintTypeList: { type: Array, default: () => [] } }, emits: ["update:visible", "configSuccess"], setup(r, { emit: x }) {
  const s = x, h = r, { visible: c, handleClose: v } = N({ emit: s, props: h, field: "visible", showHook: S }), d = g(), u = g(), { maxHeight: B } = Q({ mainBox: ".paint-config", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], paginate: true, navbar: false, clientHRepMainH: true }, () => u.value.loaded), { crud: n, CRUD: L } = j({ title: "油漆配置", crudApi: { ...$ }, queryOnPresenterCreated: false, hasPagination: true }, d);
  async function C(m) {
    try {
      await M.confirm("确定将该数据删除？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await q({ id: m.id }), O.success("删除成功！"), s("configSuccess"), n.refresh();
    } catch (i) {
      console.log(i);
    }
  }
  L.HOOK.afterSubmit = () => {
    s("configSuccess");
  };
  function k() {
    s("configSuccess"), n.resetQuery();
  }
  function S() {
    n.resetQuery();
  }
  return (m, i) => {
    const a = P, f = p("common-button"), T = p("common-table"), R = p("common-drawer"), V = U;
    return y(), b(R, { "append-to-body": "", ref_key: "drawerRef", ref: u, title: "油漆配置", modelValue: t(c), "onUpdate:modelValue": i[0] || (i[0] = (o) => D(c) ? c.value = o : null), "before-close": t(v), size: "100%", customClass: "paint-config" }, { titleAfter: l(() => i[1] || (i[1] = [])), content: l(() => [_("div", K, [e(t(I), { paintBrandList: r.paintBrandList, paintTypeList: r.paintTypeList, paintSelectList: r.paintSelectList, onSuccess: k }, null, 8, ["paintBrandList", "paintTypeList", "paintSelectList"])]), A((y(), b(T, { ref_key: "tableRef", ref: d, data: t(n).data, "empty-text": t(n).emptyText, "max-height": t(B), "row-key": "id", style: { width: "100%" } }, { default: l(() => [e(a, { label: "序号", type: "index", align: "center", width: "60" }), e(a, { prop: "paintingTypeEnum", label: "涂装类型", align: "center" }, { default: l((o) => [_("span", null, H(t(z).VL[o.row.paintingTypeEnum] || "-"), 1)]), _: 1 }), e(a, { prop: "paintBrand", label: "油漆品牌", align: "center" }), e(a, { prop: "paintType", label: "油漆类型", align: "center" }), e(a, { prop: "volumeSolidContent", label: "体积固含量（%）", align: "center" }), e(a, { prop: "unit", label: "单位", align: "center" }), e(a, { prop: "specificGravity", label: "比重（kg/L）", align: "center" }), e(a, { prop: "packageWeight", label: "包装重量", align: "center" }), e(a, { prop: "packageUnit", label: "包装单位", align: "center" }), e(a, { label: "操作", prop: "operation", align: "center" }, { default: l((o) => [e(f, { icon: "el-icon-edit", type: "primary", onClick: w((E) => t(n).toEdit(o.row), ["stop"]) }, null, 8, ["onClick"]), e(f, { icon: "el-icon-delete", type: "danger", onClick: w((E) => C(o.row), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[V, t(n).loading]]), e(t(G)), e(t(F))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  te as default
};
