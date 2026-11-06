import { ref as b } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as c } from "vue";
import { createBlock as d } from "vue";
import { withCtx as e } from "vue";
import { unref as o } from "vue";
import { createTextVNode as g } from "vue";
import { createCommentVNode as f } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as _ } from "vue";
import { createElementBlock as T } from "vue";
import { isRef as D } from "vue";
import { ElMessageBox as I } from "element-plus";
import { ElFormItem as L } from "element-plus";
import { ElForm as R } from "element-plus";
import { a as E, d as M } from "../../../../modules/notification-announcement-a0e50fbd.js";
import { u as z, G as A, p as H, R as O, S as F } from "../../../../shared/runtime.js";
import { c as P } from "../../../../modules/home-page-66a3681d.js";
const S = ["innerHTML"], J = { __name: "detail-dialog", props: { modelValue: { type: Boolean, default: false }, detailId: { type: Number, default: void 0 } }, emits: ["update:modelValue", "del-success"], setup(k, { emit: v }) {
  const m = k, y = v, { visible: r, handleClose: u } = z({ emit: y, props: m, showHook: x }), V = b(), t = b({});
  async function x() {
    try {
      const a = await E({ id: m.detailId });
      t.value = a;
    } catch (a) {
      console.log(a, "获取通知公告详情失败");
    }
  }
  async function C() {
    I.confirm("是否确认删除此通知公告？", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      try {
        await M({ id: m.detailId }), u(), y("del-success");
      } catch (a) {
        console.log(a, "删除通知公告失败");
      }
    });
  }
  return (a, l) => {
    const h = w("common-button"), s = L, N = R, B = w("common-dialog");
    return c(), d(B, { modelValue: o(r), "onUpdate:modelValue": l[0] || (l[0] = (i) => D(r) ? r.value = i : null), "before-close": o(u), title: "通知公告详情", width: "650px", showClose: false }, { titleRight: e(() => [o(A)(o(P).editNotice) ? (c(), d(h, { key: 0, type: "danger", size: "mini", onClick: C }, { default: e(() => l[1] || (l[1] = [g("删除")])), _: 1, __: [1] })) : f("", true), n(h, { onClick: o(u), size: "mini", plain: "" }, { default: e(() => l[2] || (l[2] = [g("取消")])), _: 1, __: [2] }, 8, ["onClick"])]), default: e(() => [n(N, { ref_key: "formRef", ref: V, "label-width": "90px" }, { default: e(() => [n(s, { label: "创建人" }, { default: e(() => [p("span", null, _(t.value.createUserName), 1)]), _: 1 }), n(s, { label: "日期" }, { default: e(() => [p("span", null, _(o(H)(t.value.informantDateTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 }), n(s, { label: "标题", prop: "title" }, { default: e(() => [p("span", null, _(t.value.title), 1)]), _: 1 }), n(s, { label: "内容" }, { default: e(() => {
      var i;
      return [t.value.content ? (c(), T("span", { key: 0, innerHTML: t.value.content, style: { "white-space": "pre-wrap" } }, null, 8, S)) : f("", true), (i = t.value.attachmentDTOList) != null && i.length ? (c(), d(O, { key: 1, files: t.value.attachmentDTOList, "file-classify": o(F).NORMAL.V, "empty-text": "暂未上传文件", uploadable: false, "show-download": "", "show-view": "" }, null, 8, ["files", "file-classify"])) : f("", true)];
    }), _: 1 })]), _: 1 }, 512)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  J as default
};
