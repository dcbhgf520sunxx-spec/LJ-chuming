import { ref as p } from "vue";
import { watch as G } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as g } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as l } from "vue";
import { unref as s } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as A } from "vue";
import { createElementVNode as V } from "vue";
import { withDirectives as L } from "vue";
import { createVNode as t } from "vue";
import { toDisplayString as f } from "vue";
import { withModifiers as J } from "vue";
import { isRef as K } from "vue";
import { ElMessageBox as Q } from "element-plus";
import { ElNotification as W } from "element-plus";
import { ElDescriptionsItem as X } from "element-plus";
import { ElDescriptions as Y } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElFormItem as ee } from "element-plus";
import { ElInput as te } from "element-plus";
import { ElForm as ae } from "element-plus";
import { vLoading as le } from "element-plus";
import { l as j, u as oe, o as ne, G as T, z as ie, p as z, S as re } from "../../../../../shared/runtime.js";
import { _ as se } from "../../../../../modules/PicUpload-8580ccfc.js";
function ce(i) {
  return j({ module: "project", url: "receiving/problem/page", method: "get", params: i });
}
function me(i) {
  return j({ module: "project", url: "receiving/problem/details", method: "get", params: i });
}
function ue(i) {
  return j({ module: "project", url: "receiving/problem/close", method: "put", data: i });
}
const ve = { get: ce }, de = { class: "head-container" }, pe = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, detailData: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success", "del-change"], setup(i, { emit: M }) {
  const k = M, w = i, I = p(), r = p({}), O = { picAttament: [{ required: true, validator: (c, e, a) => {
    !e || !(e != null && e.length) ? a(new Error("请上传图片")) : a();
  }, message: "请上传图片", trigger: ["change", "blur"] }], describe: [{ required: true, message: "请输入关闭原因描述", trigger: "blur" }] }, { visible: y, handleClose: R } = oe({ emit: k, props: w });
  G(y, async (c) => {
    c && (await H(), w.detailData.state === 1 ? (r.value.picAttament = d.value.attachmentDTOList, r.value.describe = d.value.remark) : (r.value.picAttament = [], r.value.describe = ""));
  }, { immediate: true });
  const h = p([]), d = p({}), B = p(), C = p(false), { maxHeight: U } = ne({ mainBox: ".delivery-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, B);
  function q(c, e) {
    h.value.splice(e, 1), k("del-change", c);
  }
  async function H() {
    var c, e;
    try {
      const a = await me({ problemId: (c = w.detailData) == null ? void 0 : c.id });
      d.value = a || {}, h.value = ((e = a == null ? void 0 : a.problemProductList) == null ? void 0 : e.content) || [];
    } catch (a) {
      console.log(a, "获取问题详情列表");
    }
  }
  async function F() {
    var e, a, m;
    if (await I.value.validate()) try {
      const b = (a = (e = r.value) == null ? void 0 : e.picAttament) == null ? void 0 : a.map((x) => x.id), o = { describe: r.value.describe, problemId: (m = w.detailData) == null ? void 0 : m.id, attachmentIds: b };
      await Q.confirm("此操作将进行关闭问题操作, 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await ue(o), W({ title: "提交成功", type: "success" }), k("success"), R();
    } catch (b) {
      console.log("审核", b);
    }
  }
  return (c, e) => {
    const a = D("common-button"), m = X, b = Y, o = Z, x = D("common-table"), E = ee, P = te, S = ae, $ = D("common-drawer"), N = le;
    return g(), _($, { ref_key: "drawerRef", ref: B, title: "问题记录", "close-on-click-modal": false, modelValue: s(y), "onUpdate:modelValue": e[2] || (e[2] = (n) => K(y) ? y.value = n : null), direction: "rtl", "before-close": s(R), "custom-class": "delivery-detail", size: "70%" }, { titleRight: l(() => {
      var n;
      return [i.detailData.state !== 1 && s(T)(i.permission.closeIssue) ? (g(), _(a, { key: 0, type: "success", size: "default", onClick: F, disabled: !((n = h.value) != null && n.length) }, { default: l(() => e[3] || (e[3] = [v("关闭问题")])), _: 1, __: [3] }, 8, ["disabled"])) : A("", true)];
    }), content: l(() => [V("div", de, [L((g(), _(b, { column: 2, border: "" }, { default: l(() => [t(m, { align: "center", "label-class-name": "contractLabel", label: "项目" }, { default: l(() => [v(f(s(ie)(d.value.project)), 1)]), _: 1 }), t(m, { align: "center", "label-class-name": "contractLabel", label: "发运日期" }, { default: l(() => [v(f(s(z)(d.value.shippingTime, "{y}-{m}-{d}")), 1)]), _: 1 }), t(m, { align: "center", "label-class-name": "contractLabel", label: "收货人" }, { default: l(() => [v(f(i.detailData.userName), 1)]), _: 1 }), t(m, { align: "center", "label-class-name": "contractLabel", label: "收货日期" }, { default: l(() => [v(f(s(z)(d.value.receivedTime, "{y}-{m}-{d}")), 1)]), _: 1 })]), _: 1 })), [[N, C.value]])]), L((g(), _(x, { data: h.value, "max-height": s(U) }, { default: l(() => [t(o, { label: "序号", type: "index", align: "center", width: "60" }), t(o, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center" }, { default: l(({ row: n }) => {
      var u;
      return [V("span", null, f(((u = n.monomer) == null ? void 0 : u.name) || "-"), 1)];
    }), _: 1 }), t(o, { key: "area.name", prop: "area.name", label: "区域", align: "center" }, { default: l(({ row: n }) => {
      var u;
      return [V("span", null, f(((u = n.area) == null ? void 0 : u.name) || "-"), 1)];
    }), _: 1 }), t(o, { "show-overflow-tooltip": true, key: "name", prop: "name", label: "名称", align: "center" }), t(o, { "show-overflow-tooltip": true, key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }), t(o, { "show-overflow-tooltip": true, key: "specification", prop: "specification", label: "规格", align: "center" }), t(o, { "show-overflow-tooltip": true, key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center" }), t(o, { "show-overflow-tooltip": true, key: "quantity", prop: "quantity", label: "数量", align: "center" }), t(o, { "show-overflow-tooltip": true, key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center" }), t(o, { "show-overflow-tooltip": true, key: "accountingMete", prop: "accountingMete", label: "核算量", align: "center" }), t(o, { "show-overflow-tooltip": true, key: "problemDesc", prop: "problemDesc", label: "问题记录", align: "center", "min-width": "130" }), i.detailData.state !== 1 && s(T)(i.permission.del) ? (g(), _(o, { key: 0, label: "操作", width: "80", align: "center" }, { default: l(({ row: { sourceRow: n }, $index: u }) => [t(a, { size: "default", icon: "el-icon-delete", type: "danger", onClick: J((fe) => q(n, u), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : A("", true)]), _: 1 }, 8, ["data", "max-height"])), [[N, C.value]]), t(S, { ref_key: "formRef", ref: I, model: r.value, rules: O, size: "default", "label-position": "top", "label-width": "100px" }, { default: l(() => [t(E, { label: "添加佐证", prop: "picAttament" }, { default: l(() => [t(s(se), { files: r.value.picAttament, "onUpdate:files": e[0] || (e[0] = (n) => r.value.picAttament = n), "file-classify": s(re).NORMAL.V, style: { width: "100%" } }, null, 8, ["files", "file-classify"])]), _: 1 }), t(E, { label: "关闭原因描述", prop: "describe" }, { default: l(() => [t(P, { modelValue: r.value.describe, "onUpdate:modelValue": e[1] || (e[1] = (n) => r.value.describe = n), type: "textarea", autosize: { minRows: 3, maxRows: 5 }, maxlength: "500", placeholder: "请填写关闭原因描述", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, we = Object.freeze(Object.defineProperty({ __proto__: null, default: pe }, Symbol.toStringTag, { value: "Module" }));
export {
  pe as _,
  ve as c,
  we as d
};
