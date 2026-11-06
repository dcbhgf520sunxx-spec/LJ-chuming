import { ref as h } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as m } from "vue";
import { createBlock as f } from "vue";
import { withCtx as e } from "vue";
import { unref as a } from "vue";
import { createTextVNode as k } from "vue";
import { createCommentVNode as p } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as _ } from "vue";
import { toDisplayString as c } from "vue";
import { createElementBlock as N } from "vue";
import { isRef as T } from "vue";
import { ElMessageBox as I } from "element-plus";
import { ElFormItem as R } from "element-plus";
import { ElForm as E } from "element-plus";
import { a as L, d as z } from "../../../../modules/company-dynamics-34941552.js";
import { u as M, G as O, p as F, R as P, S } from "../../../../shared/runtime.js";
import { c as U } from "../../../../modules/home-page-66a3681d.js";
const j = { key: 0 }, J = { __name: "detail-dialog", props: { modelValue: { type: Boolean, default: false }, detailId: { type: Number, default: void 0 } }, emits: ["update:modelValue", "del-success"], setup(v, { emit: w }) {
  const r = v, y = w, { visible: d, handleClose: u } = M({ emit: y, props: r, showHook: V }), C = h(), t = h({});
  async function V() {
    try {
      const o = await L({ id: r.detailId });
      t.value = o;
    } catch (o) {
      console.log(o, "获取公司动态详情失败");
    }
  }
  async function x() {
    I.confirm("是否确认删除此公司动态？", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      try {
        await z({ id: r.detailId }), u(), y("del-success");
      } catch (o) {
        console.log(o, "删除公司动态失败");
      }
    });
  }
  return (o, l) => {
    const b = g("common-button"), n = R, D = E, B = g("common-dialog");
    return m(), f(B, { modelValue: a(d), "onUpdate:modelValue": l[0] || (l[0] = (i) => T(d) ? d.value = i : null), "before-close": a(u), title: "公司动态详情", width: "650px", showClose: false }, { titleRight: e(() => [a(O)(a(U).editDynamics) ? (m(), f(b, { key: 0, type: "danger", size: "mini", onClick: x }, { default: e(() => l[1] || (l[1] = [k("删除")])), _: 1, __: [1] })) : p("", true), s(b, { onClick: a(u), size: "mini", plain: "" }, { default: e(() => l[2] || (l[2] = [k("取消")])), _: 1, __: [2] }, 8, ["onClick"])]), default: e(() => [s(D, { ref_key: "formRef", ref: C, "label-width": "90px" }, { default: e(() => [s(n, { label: "创建人" }, { default: e(() => [_("span", null, c(t.value.createUserName), 1)]), _: 1 }), s(n, { label: "日期" }, { default: e(() => [_("span", null, c(a(F)(t.value.informantDateTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 }), s(n, { label: "标题", prop: "title" }, { default: e(() => [_("span", null, c(t.value.title), 1)]), _: 1 }), s(n, { label: "内容" }, { default: e(() => {
      var i;
      return [t.value.content ? (m(), N("span", j, c(t.value.content), 1)) : p("", true), (i = t.value.attachmentDTOList) != null && i.length ? (m(), f(P, { key: 1, files: t.value.attachmentDTOList, "file-classify": a(S).NORMAL.V, "empty-text": "暂未上传文件", uploadable: false, "show-download": "", "show-view": "" }, null, 8, ["files", "file-classify"])) : p("", true)];
    }), _: 1 })]), _: 1 }, 512)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  J as default
};
